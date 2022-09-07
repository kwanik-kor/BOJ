package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5102
 */
public class sml_05102_SarahsToys {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            if (line[0] == 0 && line[1] == 0) {
                break;
            }
            int tot = line[0] - line[1];
            if (tot < 2) {
                bw.write("0 0\n");
            } else if (tot % 2 == 1) {
                bw.write(String.format("%d %d\n", (tot - 3) / 2, 1));
            } else {
                bw.write(String.format("%d %d\n", tot / 2, 0));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
