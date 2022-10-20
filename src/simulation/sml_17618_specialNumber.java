package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17618
 */
public class sml_17618_specialNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i <= 9) {
                cnt++;
                continue;
            }
            if (i % sumOfNumber(i) == 0) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int sumOfNumber(int number) {
        return String.valueOf(number).chars()
                .mapToObj(ch -> (char) ch)
                .mapToInt(ch -> ch - '0')
                .sum();
    }
}
