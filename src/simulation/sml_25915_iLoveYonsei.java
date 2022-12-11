package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: acmicpc.net/problem/25915
 */
public class sml_25915_iLoveYonsei {

    private static final String TEXT = "ILOVEYONSEI";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char current = br.readLine().charAt(0);

        int tot = 0;
        for (int i = 0; i < 11; i++) {
            tot += Math.abs(current - TEXT.charAt(i));
            current = TEXT.charAt(i);
        }

        bw.write(tot + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
