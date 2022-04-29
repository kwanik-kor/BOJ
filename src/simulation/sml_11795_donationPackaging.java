package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11795
 */
public class sml_11795_donationPackaging {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a += Integer.parseInt(st.nextToken());
            b += Integer.parseInt(st.nextToken());
            c += Integer.parseInt(st.nextToken());
            int min = Math.min(a, Math.min(b, c));
            if (30 <= min) {
                bw.write(min + "\n");
                a -= min;
                b -= min;
                c -= min;
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
