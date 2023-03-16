package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15953
 */
public class sml_15953_rewardHunter {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[][] FIRST = {{1, 500}, {3, 300}, {6, 200}, {10, 50}, {15, 30}, {21, 10}};
    static final int[][] SECOND = {{1, 512}, {3, 256}, {7, 128}, {15, 64}, {31, 32}};

    void solve() throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            if (a != 0) {
                for (int i = 0; i < 6; i++) {
                    if (a <= FIRST[i][0]) {
                        sum += FIRST[i][1];
                        break;
                    }
                }
            }

            if (b != 0) {
                for (int i = 0; i < 5; i++) {
                    if (b <= SECOND[i][0]) {
                        sum += SECOND[i][1];
                        break;
                    }
                }
            }
            System.out.println(sum * 10000);
        }
    }

    public static void main(String[] args) throws Exception {
        new sml_15953_rewardHunter().solve();
    }

}
