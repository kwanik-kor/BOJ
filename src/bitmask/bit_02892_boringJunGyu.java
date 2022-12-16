package bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2892
 */
public class bit_02892_boringJunGyu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(input[i], 16);

            boolean flag = false;
            for (int j = 48; j < 58; j++) {
                int origin = target ^ j;
                if (97 <= origin && origin <= 122) {
                    flag = true;
                    break;
                }
            }

            bw.write(flag? "-" : ".");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
