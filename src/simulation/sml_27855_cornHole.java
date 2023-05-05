package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27855
 */
public class sml_27855_cornHole {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int score1 = h1 * 3 + b1;
        int score2 = h2 * 3 + b2;
        if (score1 > score2) {
            bw.write("1 " + (score1 - score2));
        } else if (score2 > score1) {
            bw.write("2 " + (score2 - score1));
        } else {
            bw.write("NO SCORE");
        }

        bw.close();
        br.close();
    }
}
