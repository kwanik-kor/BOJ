package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1159
 */
public class sml_1159_basketball {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        while (N-- > 0) {
            cnt[br.readLine().charAt(0) - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 5) {
                bw.write(((char) i + 'a'));
                ans++;
            }
        }
        if (ans == 0) {
            bw.write("PREDAJA");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
