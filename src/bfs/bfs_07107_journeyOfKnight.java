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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/7107
 * 2. 풀이
 *  - 단순한 BFS 유형의 문제로 체스 나이트의 움직임을 만드는 문제였음
 */
public class bfs_07107_journeyOfKnight {

    static int R, C;
    static Node end;

    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visit;

    static int solve() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now.n;

            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(isOutBound(ny, nx) || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx, now.n + 1));
            }
        }

        return -1;
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || R <= y || C <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int i = Integer.parseInt(st.nextToken()) - 1;
        int j = Integer.parseInt(st.nextToken()) - 1;
        end = new Node(j, i, 0);

        visit = new boolean[R][C];
        int ans = solve();

        bw.write(ans == -1? "NEVAR" : (ans +""));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x, n;
        public Node(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}
