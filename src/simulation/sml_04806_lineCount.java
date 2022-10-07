package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4806
 */
public class sml_04806_lineCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
