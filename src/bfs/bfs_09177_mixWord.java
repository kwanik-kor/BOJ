package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9177
 * 2. 풀이
 *   - 양 단어(a, b)의 idx에 해당하는 글자가 동일할 수 있기 때문에 BFS로 순차 진행
 * 3. 풀이2
 *   - DP로도 풀어보자
 */
public class bfs_09177_mixWord {

    static int a_len, b_len, length;
    static char[] a, b, comb;

    static boolean[][] visit;

    static boolean solve() {
        visit = new boolean[201][201];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            int k = now.a_idx + now.b_idx;
            if(k == length && now.a_idx == a_len && now.b_idx == b_len)
                return true;

            if(now.a_idx != a_len && a[now.a_idx] == comb[k] && !visit[now.a_idx + 1][now.b_idx]) {
                visit[now.a_idx + 1][now.b_idx] = true;
                q.add(new Point(now.a_idx + 1, now.b_idx));
            }
            if(now.b_idx != b_len && b[now.b_idx] == comb[k] && !visit[now.a_idx][now.b_idx + 1]) {
                visit[now.a_idx][now.b_idx + 1] = true;
                q.add(new Point(now.a_idx, now.b_idx + 1));
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Integer N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().toCharArray();
            b = st.nextToken().toCharArray();
            comb = st.nextToken().toCharArray();

            a_len = a.length;
            b_len = b.length;
            length = a_len + b_len;

            bw.write(String.format("Data set %d: %s\n", n, solve()? "yes" : "no"));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int a_idx;
        int b_idx;
        public Point(int a_idx, int b_idx) {
            this.a_idx = a_idx;
            this.b_idx = b_idx;
        }
    }
}
