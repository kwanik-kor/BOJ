package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23971
 */
public class sml_23971_zoac4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToDouble(Double::valueOf)
                        .toArray();
        double a = Math.ceil(arr[0] / (arr[2] + 1));
        double b = Math.ceil(arr[1] / (arr[3] + 1));
        bw.write(String.format("%.0f", a * b));
        bw.flush();
        bw.close();
        br.close();
    }
}
