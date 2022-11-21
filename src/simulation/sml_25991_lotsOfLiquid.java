package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25991
 */
public class sml_25991_lotsOfLiquid {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double tot = 0d;
        for (int i = 0; i < N; i++) {
            Double value = Double.parseDouble(st.nextToken());
            tot += value * value * value;
        }

        bw.write(String.format("%.6f", Math.pow(tot, 1d / 3d)));
        bw.flush();
        bw.close();
        br.close();
    }
}
