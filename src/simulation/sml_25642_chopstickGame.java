package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25642
 */
public class sml_25642_chopstickGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean flag = false;
        while (a < 5 && b < 5) {
            if (flag) {
                a += b;
            } else {
                b += a;
            }
            flag = !flag;
        }

        bw.write(a >= 5 ? "yj" : "yt");
        bw.close();
        br.close();
    }

}
