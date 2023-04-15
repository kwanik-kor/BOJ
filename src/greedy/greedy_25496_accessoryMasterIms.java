package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25496
 */
public class greedy_25496_accessoryMasterIms {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-- > 0) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int left = 200 - P;
        int cnt = 0;
        while (left > 0 && !pq.isEmpty()) {
            left -= pq.poll();
            cnt++;
        }

        bw.write(cnt + "");
        bw.close();
        br.close();
    }

}
