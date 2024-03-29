package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크:https://www.acmicpc.net/problem/26772
 */
public class sml_26772_poziomeSerca {

    static final String[] LINES = {
            " @@@   @@@ ",
            "@   @ @   @",
            "@    @    @",
            "@         @",
            " @       @ ",
            "  @     @  ",
            "   @   @   ",
            "    @ @    ",
            "     @     "
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0, n = LINES.length; i < n; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(LINES[i]);
                if (j != N - 1) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
