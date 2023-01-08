package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10188
 */
public class sml_10188_qudrilateral {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < line[1]; i++) {
                for (int j = 0; j < line[0]; j++) {
                    bw.write("X");
                }
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
