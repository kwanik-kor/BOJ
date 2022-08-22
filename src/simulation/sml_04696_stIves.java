package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4696
 */
public class sml_04696_stIves {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            double a = Double.parseDouble(br.readLine());
            if (a == 0d) {
                break;
            }
            bw.write(String.format("%.2f\n", 1 + a + Math.pow(a, 2) + Math.pow(a, 3) + Math.pow(a, 4)));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
