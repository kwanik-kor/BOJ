package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1439
 */
public class sml_01439_turnOver {
    static char[] arr;
    static boolean[] visit;

    static void check(int i, int flag) {
        while (true) {
            visit[i] = true;
            i++;
            if (i >= visit.length || arr[i] != flag) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = br.readLine().toCharArray();
        visit = new boolean[arr.length];

        int zero = 0;
        int one = 0;
        for (int i = 0, n = arr.length; i < n; i++) {
            if (!visit[i]) {
                check(i, arr[i]);
                if (arr[i] == '0') zero++;
                else one++;
            }
        }
        bw.write(Math.min(zero, one) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
