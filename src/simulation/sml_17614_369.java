package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17614
 */
public class sml_17614_369 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            cnt += countThree(i);
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int countThree(int n) {
        int cnt = 0;
        while (n > 0) {
            int mod = n % 10;
            if (mod == 3 || mod == 6 || mod == 9) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}
