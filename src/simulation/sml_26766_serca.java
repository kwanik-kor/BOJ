package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26766
 */
public class sml_26766_serca {
    static final String heart = " @@@   @@@ \n" +
            "@   @ @   @\n" +
            "@    @    @\n" +
            "@         @\n" +
            " @       @ \n" +
            "  @     @  \n" +
            "   @   @   \n" +
            "    @ @    \n" +
            "     @     ";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            bw.write(heart + "\n");
        }
        bw.close();
        br.close();
    }
}
