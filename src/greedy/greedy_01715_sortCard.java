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

        int tot = 0;
        while (pq.size() != 1) {
            int joined = pq.poll() + pq.poll();
            tot += (joined);
            pq.add(joined);
        }

        bw.write(tot + "");
        br.close();
        bw.close();
    }
}
