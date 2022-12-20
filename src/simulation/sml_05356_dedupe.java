package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5357
 */
public class sml_05356_dedupe {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] line = br.readLine().toCharArray();
            bw.write(line[0]);
            for (int i = 1, n = line.length; i < n; i++) {
                if (line[i] == line[i - 1]) continue;
                bw.write(line[i]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
