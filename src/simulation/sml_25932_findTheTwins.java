package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25932
 */
public class sml_25932_findTheTwins {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();
            int[] arr = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean zack = false;
            boolean mack = false;
            for (int i = 0; i < 10; i++) {
                if (arr[i] == 17) {
                    zack = true;
                } else if (arr[i] == 18) {
                    mack = true;
                }
            }

            String result = "none";
            if (zack && mack) {
                result = "both";
            } else if (zack && !mack) {
                result = "zack";
            } else if (!zack && mack) {
                result = "mack";
            }
            bw.write(String.format("%s\n%s\n", line, result));
            if (T != 0) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
