package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9698
 */
public class sml_09698_sahur {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            boolean flag = false;

            minute -= 45;
            if (minute < 0) {
                minute += 60;
                flag = true;
            }

            if (flag) {
                hour--;
                if (hour < 0) {
                    hour += 24;
                }
            }

            bw.write(String.format("Case #%d: %d %d\n", i, hour, minute));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
