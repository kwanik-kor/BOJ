package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1343
 */
public class greedy_01343_polyomino {

    private static final char POINT = 'X';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();

        boolean flag = true;
        for (int i = 0, n = line.length; i < n; i++) {
            if (!flag) break;

            if (line[i] == POINT) {
                flag = convertWithPolyomino(line, i);
            }
        }

        bw.write(flag ? new String(line) : "-1");

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean convertWithPolyomino(char[] sequence, int idx) {
        int length = 0;
        for (int i = idx, n = sequence.length; i < n; i++) {
            if (sequence[i] != POINT) {
                break;
            }
            length++;
        }

        if ((length % 4) % 2 != 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = length / 4; i < n; i++) {
            sb.append("AAAA");
        }

        for (int i = 0, n = (length % 4) / 2; i < n; i++) {
            sb.append("BB");
        }

        for (int i = 0; i < length; i++) {
            sequence[i + idx] = sb.charAt(i);
        }

        return true;
    }
}
