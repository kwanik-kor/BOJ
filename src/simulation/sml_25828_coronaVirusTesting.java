package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25828
 */
public class sml_25828_coronaVirusTesting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int a = arr[0] * arr[1];
        int b = arr[0] + arr[1] * arr[2];

        if (a < b) {
            bw.write("1");
        } else if (b < a) {
            bw.write("2");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
