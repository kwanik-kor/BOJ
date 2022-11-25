package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17450
 */
public class sml_17450_buyCookie {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double[] s = convertLineToIntArray(br.readLine());
        double[] n = convertLineToIntArray(br.readLine());
        double[] u = convertLineToIntArray(br.readLine());

        double sTot = s[1] * 10 / ((s[0] * 10) - (s[0] * 10 >= 5000 ? 500 : 0));
        double nTot = n[1] * 10 / ((n[0] * 10) - (n[0] * 10 >= 5000 ? 500 : 0));
        double uTot = u[1] * 10 / ((u[0] * 10) - (u[0] * 10 >= 5000 ? 500 : 0));

        double max = Math.max(sTot, Math.max(nTot, uTot));
        if (max == sTot) {
            bw.write("S");
        } else if (max == nTot) {
            bw.write("N");
        } else {
            bw.write("U");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static double[] convertLineToIntArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
