package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1781
 */
public class greedy_01781_cupNoodle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        boolean[] check = new boolean[N + 1];
        long tot = 0L;
        while (!pq.isEmpty()) {
            Problem p = pq.poll();
            for (int i = p.deadline; i >= 1; i--) {
                if (!check[i]) {
                    check[i] = true;
                    tot += p.cnt;
                    break;
                }
            }
        }
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Problem implements Comparable<Problem> {
        int deadline;
        int cnt;

        public Problem(int deadline, int cnt) {
            this.deadline = deadline;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Problem o) {
            if (o.cnt == this.cnt) {
                return o.deadline - this.deadline;
            }
            return o.cnt - this.cnt;
        }
    }

}
