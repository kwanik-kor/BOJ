package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14924
 * 2. 풀이
 *  - 왜 정수로 출력이란 조건이 없음요?
 */
public class math_14924_VonNeumannAndParis {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
//        double S = Double.parseDouble(st.nextToken());
//        double T = Double.parseDouble(st.nextToken());
//        double D = Double.parseDouble(st.nextToken());

        bw.write(D / (S * 2) * T + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
