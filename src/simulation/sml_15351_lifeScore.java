package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15351
 */
public class sml_15351_lifeScore {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int tot = 0;
            for (int i = 0, n = arr.length; i < n; i++) {
                if (arr[i] == ' ') continue;
                tot += arr[i] - 'A' + 1;
            }
            bw.write(tot == 100 ? "PERFECT LIFE\n" : (tot + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
