package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9501
 */
public class sml_09501_spaceTravel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                double v = Double.parseDouble(st.nextToken());
                double f = Double.parseDouble(st.nextToken());
                double c = Double.parseDouble(st.nextToken());
                if (v * f / c >= D) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
