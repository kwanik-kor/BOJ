package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3059
 */
public class sml_03059_notAppearedCharacter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line = br.readLine();
            int tot = 0;
            for (int i = 65; i <= 90; i++) {
                if (line.indexOf((char) i) == -1) {
                    tot += i;
                }
            }
            bw.write(tot + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
