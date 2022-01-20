package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/22682
 * 2. 풀이
 *  - https://www.acmicpc.net/problem/7669 의 Go 문제와 동일한 문제라고 볼 수 있다.
 *   - B / W 로 둘러쌓인 각각의 영역의 너비를 구하면 되는 문제. 별 다른 어려운 것은 없음
 */
public class bfs_22682_surroundingArea {

    static final char BLACK = 'B', WHITE = 'W', SEA = '.';

    static int W, H;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visit;

    static String solve() {
        int black = 0, white = 0;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(map[i][j] == SEA) continue;

                char type = map[i][j];

                for(int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(isOutBound(ny, nx) || visit[ny][nx] || map[ny][nx] != SEA) continue;

                    int result = getTerritory(ny, nx, type);

                    if(result == -1) continue;

                    if(type == BLACK) black += result;
                    else white += result;
                }
            }
        }

        return String.format("%d %d\n", black, white);
    }

    static int getTerritory(int y, int x, char type) {
        int ret = 1;
        boolean flag = true;

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(y, x));
        visit[y][x] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(isOutBound(ny, nx) || visit[ny][nx]) continue;
                if(map[ny][nx] != SEA) {
                    if(map[ny][nx] != type)
                        flag = false;
                    continue;
                }

                ret++;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx));
            }
        }

        return flag? ret : -1;
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || H <= y || W <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W == 0 && H == 0)
                break;

            map = new char[H][W];
            visit = new boolean[H][W];
            for(int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            bw.write(solve());
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
    }
}
