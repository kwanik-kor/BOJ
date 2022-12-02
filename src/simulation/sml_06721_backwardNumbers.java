package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6721
 */
public class sml_06721_backwardNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int ans = Integer.parseInt(
                    new StringBuilder(
                            String.valueOf(Arrays.stream(br.readLine().split(" "))
                                .mapToInt(str -> Integer.parseInt(new StringBuilder(str).reverse().toString()))
                                .sum()))
                        .reverse()
                        .toString()
            );

            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
