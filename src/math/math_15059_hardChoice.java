package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15059
 */
public class math_15059_hardChoice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int tot = 0;
        for(int i = 0; i < 3; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            tot += (b > a) ? b - a : 0;
        }

        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
