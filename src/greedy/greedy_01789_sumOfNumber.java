package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1789
 */
public class greedy_01789_sumOfNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long S = Long.parseLong(br.readLine());

        long sum = 0L;
        long flag = 1L;
        int cnt = 0;
        while (true) {
            sum += flag;
            cnt++;
            if (sum > S) {
                cnt--;
                break;
            }
            flag++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
