package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5356
 */
public class sml_05356_triangles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int letter = st.nextToken().charAt(0);
            for (int i = 1; i <= n; i++) {
                if (letter > 'Z') letter = 'A';
                for (int j = 1; j <= i; j++) {
                    bw.write((char) letter);
                }
                letter++;
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
