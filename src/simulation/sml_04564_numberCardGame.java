package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4564
 */
public class sml_04564_numberCardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            char[] numbers = String.valueOf(n).toCharArray();
            if (numbers.length == 1) {
                bw.write(n + "\n");
                continue;
            }

            while (numbers.length != 1) {
                bw.write(String.valueOf(numbers) + " ");
                int tot = 1;
                for (int i = 0; i < numbers.length; i++) {
                    tot *= numbers[i] - '0';
                }
                numbers = String.valueOf(tot).toCharArray();
            }

            bw.write(String.valueOf(numbers) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
