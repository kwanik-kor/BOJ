package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/7595
 */
public class sml_07595_triangles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    bw.write("*");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
