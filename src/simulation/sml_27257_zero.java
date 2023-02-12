package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27257
 */
public class sml_27257_zero {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = new StringBuilder(br.readLine()).reverse().toString().toCharArray();

        boolean flag = false;
        int cnt = 0;

        for (int i = 0, n = arr.length; i < n; i++) {
            if (!flag && arr[i] != '0') {
                flag = true;
                continue;
            }

            if (flag && arr[i] == '0') {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
