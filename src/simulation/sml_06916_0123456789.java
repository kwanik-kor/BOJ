package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6916
 */
public class sml_06916_0123456789 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N == 0 || N == 2 || N == 3 || N == 5 || N == 6 || N == 7 || N == 8 || N == 9) {
            bw.write(" * * *");
        }
        bw.write("\n");
        for (int i = 0; i < 3; i++) {
            if (N == 0 || N == 4 || N == 8 || N == 9) bw.write("*     *");
            else if (N == 5 || N == 6) bw.write("*");
            else bw.write("      *");
            bw.write("\n");
        }
        if (N == 2 || N == 3 || N == 4 || N == 5 || N == 6 || N == 8 || N == 9) bw.write(" * * *");
        bw.write("\n");
        for (int i = 0; i < 3; i++) {
            if (N == 0 || N == 6 || N == 8) bw.write("*     *");
            else if (N == 1 || N == 3 || N == 4 || N == 5 || N == 7 || N == 9) bw.write("      *");
            else bw.write("*");
            bw.write("\n");
        }
        if (N == 0 || N == 2 || N == 3 || N == 5 || N == 6 || N == 8 || N == 9) bw.write(" * * *");
        bw.write("\n");
        bw.close();
        br.close();
    }
}
