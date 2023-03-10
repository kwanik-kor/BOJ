package greedy;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1715
 */
public class greedy_01715_sortCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        int tot = 0;
        while (!pq.isEmpty()) {
            if (cnt == N - 1) break;
            int a = pq.poll();
            int b = pq.poll();

            tot += (a + b);
            pq.add(a + b);
            cnt++;
        }

        bw.write(tot + "");
        br.close();
        bw.close();
    }
}
