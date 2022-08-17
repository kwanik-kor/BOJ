package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13118
 */
public class sml_13118_newtonAndApple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] p = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();

        int x = Integer.parseInt(br.readLine().split(" ")[0]);
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            if (x == p[i]) {
                idx = i + 1;
                break;
            }
        }
        bw.write(idx + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
