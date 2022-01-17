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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6191
 * 2. 풀이
 *  - 시작점에서 도착점까지의 경로를 탐색하되 해당 경로를 최종적으로 출력하는 문제 였다.
 *   - 노드 경로를 단일 배열로 구성하고, 해당 지점으로 오게된 이전 노드의 번호를 기억하게 하여
 *     경로탐색을 마친 후에, 최종적으로 경로를 출력함
 */
public class bfs_06191_cowsOnSkates {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[] path;
    static char[][] map;

    static void solve() {
        boolean[][] visit = new boolean[R + 1][C + 1];

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(1, 1));
        visit[1][1] = true;
        path[1] = 1;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.y == R && now.x == C)
                return;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 1 || nx < 1 || R + 1 <= ny || C + 1 <= nx || map[ny][nx] == '*' || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                path[nodeToInt(ny, nx)] = nodeToInt(now.y, now.x);
                q.add(new Node(ny, nx));
            }
        }
    }

    static String getPath() {
        StringBuilder sb = new StringBuilder("");

        int node = (R + 1) * (C + 1) - 1;
        sb.insert(0, intToNodeString(node));

        while(true) {
            node = path[node];
            sb.insert(0, intToNodeString(node));
            if(node == C + 2)
                break;
        }

        return sb.toString();
    }

    static int nodeToInt(int y, int x) {
        return (y * (C + 1)) + x;
    }

    static String intToNodeString(int node) {
        int y = node / (C + 1);
        int x = node % (C + 1);
        return String.format("%d %d\n", y, x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 1][C + 1];
        path = new int[(R + 1) * (C + 1)];
        for(int i = 1; i <= R; i++) {
            String str = br.readLine();
            for(int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        solve();

        bw.write(getPath());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
