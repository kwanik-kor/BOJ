package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/23747
 * 2. 풀이
 *  - 단순 시뮬레이션으로 문제의 요구사항에 따라 순차적으로 작업을 처리해주면 된다!
 *  - 지정된 영역에 시야를 밝혀줄 때 BFS를 사용
 */
public class bfs_23747_ward {

    static final char MIST = '#', SIGHT = '.', WARD = 'W';
    static final String DIRECTION = "URDL";

    static int R, C;
    static String path;
    static Node hanByul;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] area;
    static char[][] see;

    static void solve() {
        int dir;

        for(int idx = 0, n = path.length(); idx < n; idx++) {
            char command = path.charAt(idx);

            if(command == WARD && see[hanByul.y][hanByul.x] != SIGHT) {
                setWard(hanByul, area[hanByul.y][hanByul.x]);
                continue;
            }

            dir = DIRECTION.indexOf(command);
            hanByul.setY(hanByul.y + dy[dir]);
            hanByul.setX(hanByul.x + dx[dir]);
        }

        setLastSight(hanByul);
    }

    static void setLastSight(Node pos) {
        see[pos.y][pos.x] = SIGHT;
        for(int dir = 0; dir < 4; dir++) {
            int ny = pos.y + dy[dir];
            int nx = pos.x + dx[dir];
            if(isOutBound(ny, nx)) continue;
            see[ny][nx] = SIGHT;
        }
    }

    static void setWard(Node pos, char type) {
        Queue<Node> q = new LinkedList<>();
        q.add(pos);
        see[pos.y][pos.x] = SIGHT;
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(isOutBound(ny, nx) || area[ny][nx] != type || see[ny][nx] == SIGHT) continue;
                see[ny][nx] = SIGHT;
                q.add(new Node(ny, nx));
            }
        }
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || R <= y || C <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new char[R][C];
        see = new char[R][C];
        for(int i = 0; i < R; i++) {
            area[i] = br.readLine().toCharArray();
            Arrays.fill(see[i], '#');
        }

        st = new StringTokenizer(br.readLine());
        hanByul = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        path = br.readLine();

        solve();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                bw.write(see[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
