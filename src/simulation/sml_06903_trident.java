package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6903
 */
public class sml_06903_trident {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int height = Integer.parseInt(br.readLine());
        int width = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());

        for (int i = 0, n = height + length + 1; i < n; i++) {
            if (i < height) {
                for (int j = 0; j < 3; j++) {
                    bw.write("*");
                    if (j != 2) {
                        for (int k = 0; k < width; k++) {
                            bw.write(" ");
                        }
                    } else {
                        bw.write("\n");
                    }
                }
            } else if (i == height) {
                for (int k = 0, l = 3 + width * 2; k < l; k++) {
                    bw.write("*");
                }
                bw.write("\n");
            } else {
                for (int k = 0, l = 1 + width; k < l; k++) {
                    bw.write(" ");
                }
                bw.write("*\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
