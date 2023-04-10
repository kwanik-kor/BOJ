package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18406
 */
public class sml_18406_luckyStraight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        int a = 0, b = 0;
        int length = line.length();
        for (int i = 0; i < length; i++) {
            if (i < length / 2) {
                a += line.charAt(i) - '0';
            } else {
                b += line.charAt(i) - '0';
            }
        }

        bw.write(a == b ? "LUCKY" : "READY");
        bw.close();
        br.close();
    }

}
