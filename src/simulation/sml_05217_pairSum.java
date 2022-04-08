package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5217
 */
public class sml_05217_pairSum {

    static String[] ans = new String[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        setUp();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            bw.write(ans[Integer.parseInt(br.readLine())]);
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static void setUp() {
        for (int no = 1; no <= 12; no++) {
            StringBuilder sb = new StringBuilder("Pairs for " + no + ": ");
            for (int i = 1; i <= no / 2; i++) {
                int sub = no - i;
                if(sub == 0 || i == sub) break;
                sb.append(String.format("%d %d, ", i, sub));
            }
            String val = sb.toString();
            if (no > 2)
                val = val.substring(0, val.length() - 2);
            ans[no] = val + "\n";
        }

    }
}
