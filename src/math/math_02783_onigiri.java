package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2783
 */
public class math_02783_onigiri {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double min = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            min = Math.min(min, Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()));
        }

        bw.write(String.format("%.2f", min * 1000));
        bw.flush();
        bw.close();
        br.close();
    }
}
