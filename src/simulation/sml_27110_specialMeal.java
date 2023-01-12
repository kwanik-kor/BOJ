package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27110
 */
public class sml_27110_specialMeal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int tot = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(str -> Math.min(Integer.parseInt(str), N))
                        .sum();
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
