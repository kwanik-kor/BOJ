package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23805
 */
public class sml_23805_putAtSign {

    static int N, max;
    static char[][] map;
    static final char SIGN = '@', BLANK = ' ';

    static void fillColumn(int x) {
        for (int i = 0; i < max; i++) {
            for (int j = x; j < x + N; j++) {
                map[i][j] = SIGN;
            }
        }
    }

    static void fillPart(int type, int x) {
        for (int i = 0; i < max; i++) {
            for (int j = x; j < x + N; j++) {
                map[i][j] = BLANK;
                if (type == 0 && i < N) {
                    map[i][j] = SIGN;
                } else if (type == 1 && max - N <= i) {
                    map[i][j] = SIGN;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        max = N * 5;
        map = new char[max][max];
        for (int i = 0; i < max; i += N) {
            if ((i / N) % 2 == 0) {
                fillColumn(i);
                continue;
            }
            fillPart((i / N / 2) % 2, i);
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
