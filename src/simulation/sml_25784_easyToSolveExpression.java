package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25784
 */
public class sml_25784_easyToSolveExpression {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Arrays.sort(inputs);
        if (inputs[0] + inputs[1] == inputs[2]) {
            bw.write("1");
        } else if(inputs[0] * inputs[1] == inputs[2]) {
            bw.write("2");
        } else {
            bw.write("3");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
