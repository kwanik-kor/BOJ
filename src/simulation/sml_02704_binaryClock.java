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
 * 1. 문제 링크: https://www.acmicpc.net/problem/2704
 */
public class sml_02704_binaryClock {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<Integer> clock = Arrays.stream(br.readLine().split(":"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            char[][] binary = new char[3][6];
            int idx = 0;
            StringBuilder row = new StringBuilder("");
            for (Integer time : clock) {
                binary[idx] = String.format("%06d", Integer.parseInt(Integer.toBinaryString(time))).toCharArray();
                row.append(binary[idx++]);
            }

            StringBuilder col = new StringBuilder("");
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    col.append(binary[j][i]);
                }
            }
            bw.write(col.toString() + " " + row.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
