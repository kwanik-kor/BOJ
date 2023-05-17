package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4118
 */
public class sml_04118_fredsLottoTickets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            if (n < 9) {
                while (n-- > 0) {
                    br.readLine();
                }
                bw.write("No\n");
            } else {
                Set<Integer> set = new HashSet<>();
                while (n-- > 0) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while (st.hasMoreTokens()) {
                        set.add(Integer.parseInt(st.nextToken()));
                    }
                }
                bw.write(set.size() == 49 ? "Yes\n" : "No\n");
            }
        }
        bw.close();
        br.close();
    }
}
