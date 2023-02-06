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
 * 1. 문제 링크: https://www.acmicpc.net/problem/25418
 */
public class bfs_25418_integerAToK {

    static int A, K;
    static int[] map = new int[1000001];

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(K);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (now == A) break;

            if (now % 2 == 0 && now / 2 >= 0 && map[now / 2] == 0) {
                q.add(now / 2);
                map[now / 2] = map[now] + 1;
            }

            if (now - 1 >= 0 && map[now - 1] == 0) {
                q.add(now - 1);
                map[now - 1] = map[now] + 1;
            }
        }

        return map[A];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
