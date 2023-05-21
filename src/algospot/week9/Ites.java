package algospot.week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/ITES
 */
public class Ites {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int SIGNAL_MOD = 10000;

    public static void main(String[] args) throws Exception {
        Ites main = new Ites();

        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        long signal = 1983;
        int sum = 0;
        int total = 0;

        while (n-- > 0) {
            int input = (int) (signal % SIGNAL_MOD + 1);
            sum += input;
            q.add(input);

            while (sum > k && q.size() > 1) {
                sum -= q.poll();
            }
            if (sum == k) {
                total++;
            }
            signal = (signal * 214013 + 2531011) % (1L << 32);
        }

        bw.write(total + "\n");
    }

}
