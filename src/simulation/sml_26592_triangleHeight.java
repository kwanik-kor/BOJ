package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26592
 */
public class sml_26592_triangleHeight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            double[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            bw.write(String.format("The height of the triangle is %.2f units\n", line[0] * 2 / line[1]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
