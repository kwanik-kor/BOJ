package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25813
 */
public class sml_25813_changingStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int uIndex = line.indexOf('U');
        int fIndex = line.lastIndexOf('F');

        for (int i = 0, n = line.length(); i < n; i++) {
            if (i < uIndex || i > fIndex) {
                bw.write('-');
            } else if (i == uIndex) {
                bw.write('U');
            } else if (i == fIndex) {
                bw.write('F');
            } else {
                bw.write('C');
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
