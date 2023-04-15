package algospot.week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/STRJOIN
 * 2. 풀이
 *  - 문자열을 합치는 과정에서 먼저 합쳐진 것은 누적됨에 따라, 가장 짧은 문자열을 먼저 더해줘야 함
 *  - https://www.acmicpc.net/problem/1715 과 동일한 형태의 문제
 */
public class StrJoin {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StrJoin main = new StrJoin();

        int cases = Integer.parseInt(br.readLine());
        while (cases-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int tot = 0;
        while (pq.size() != 1) {
            int joined = pq.poll() + pq.poll();
            tot += joined;
            pq.add(joined);
        }

        bw.write(String.format("%d\n", tot));
    }

}
