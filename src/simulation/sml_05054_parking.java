package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5054
 */
public class sml_05054_parking {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            int avg = arr.stream().mapToInt(Integer::intValue).sum() / N;
            bw.write(2 * (arr.get(N - 1) - avg) + 2 * (avg - arr.get(0)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
