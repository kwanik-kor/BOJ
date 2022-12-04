package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26209
 */
public class sml_26209_interceptingInformation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean result = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .anyMatch(num -> num == 9);
        bw.write(result ? "F" : "S");
        bw.flush();
        bw.close();
        br.close();
    }
}
