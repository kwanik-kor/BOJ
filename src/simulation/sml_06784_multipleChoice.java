package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6784
 */
public class sml_06784_multipleChoice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] ans = new String[N];
        for (int i = 0; i < N; i++) {
            ans[i] = br.readLine();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (ans[i].equals(br.readLine()))
                cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
