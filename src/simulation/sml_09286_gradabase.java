package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9286
 */
public class sml_09286_gradabase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            bw.write("Case " + i + ":\n");
            int m = Integer.parseInt(br.readLine());
            while(m-- > 0) {
                int k = Integer.parseInt(br.readLine()) + 1;
                if (1 <= k && k <= 6) {
                    bw.write(k + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
