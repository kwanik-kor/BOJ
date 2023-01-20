package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/19572
 */
public class sml_19572_drought {

    /*
     d1 = a + b
     d2 = a + c
     d3 = b + c
     d1 + d2 + d3 = 2(a + b + c);
    (a + b + c) = (d1 + d2 + d3) / 2;

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double[] input = Arrays.stream(br.readLine().split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();

        double tot = (input[0] + input[1] + input[2]) / 2.0d;
        double a = tot - input[2];
        double b = tot - input[1];
        double c = tot - input[0];

        if (a <= 0 || b <= 0 || c <= 0) {
            bw.write("-1");
        } else {
            bw.write(String.format("1\n%.1f %.1f %.1f", a, b, c));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
