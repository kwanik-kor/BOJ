package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5361
 */
public class math_05361_warDroidPrice {

    static final double[] price = {350.34, 230.90, 190.55, 125.30, 180.90};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double tot = IntStream.range(0, 5)
                    .mapToDouble(idx -> price[idx] * Double.parseDouble(st.nextToken()))
                    .sum();
            bw.write(String.format("$%.02f\n", tot));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
