package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23348
 */
public class sml_23348_streetCodingFighter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] score = stringToIntArray(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        while (N-- > 0) {
            int temp = 0;
            for (int i = 0; i < 3; i++) {
                int[] line = stringToIntArray(br.readLine());
                temp += IntStream.range(0, 3)
                        .map(idx -> score[idx] * line[idx])
                        .sum();
            }
            max = Math.max(max, temp);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] stringToIntArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
