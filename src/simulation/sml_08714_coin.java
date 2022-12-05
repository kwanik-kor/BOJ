package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/8714
 */
public class sml_08714_coin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = (int) Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .filter(num -> num == 0)
                        .count();
        bw.write(Math.min(cnt, N - cnt) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
