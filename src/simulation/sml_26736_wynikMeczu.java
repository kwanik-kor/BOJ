package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26736
 */
public class sml_26736_wynikMeczu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ans = new int[2];
        char[] line = br.readLine().toCharArray();

        for (int i = 0, n = line.length; i < n; i++) {
            ans[line[i] == 'A' ? 0 : 1]++;
        }

        bw.write(ans[0] + " : " + ans[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}
