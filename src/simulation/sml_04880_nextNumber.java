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
 * 1. 문제 링크: https://www.acmicpc.net/problem/4880
 */
public class sml_04880_nextNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (arr.get(0) == 0 && arr.get(1) == 0 && arr.get(2) == 0) break;
            if (arr.get(1) - arr.get(0) == arr.get(2) - arr.get(1)) {
                bw.write("AP " + (arr.get(2) + arr.get(2) - arr.get(1)) + "\n");
            } else {
                bw.write("GP " + (arr.get(2) * arr.get(2) / arr.get(1)) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
