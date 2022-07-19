package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14215
 */
public class sml_14215_threeSticks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        bw.write(arr[0] + arr[1] + Math.min(arr[2], arr[0] + arr[1] - 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
