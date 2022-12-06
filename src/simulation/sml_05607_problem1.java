package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5607
 */
public class sml_05607_problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aTemp = Integer.parseInt(st.nextToken());
            int bTemp = Integer.parseInt(st.nextToken());
            if (aTemp > bTemp) {
                a += aTemp + bTemp;
            } else if (aTemp == bTemp) {
                a += aTemp;
                b += bTemp;
            } else {
                b += aTemp + bTemp;
            }
        }

        bw.write(a + " " + b);
        bw.flush();
        bw.close();
        br.close();
    }
}
