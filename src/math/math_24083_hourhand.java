package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24083
 */
public class math_24083_hourhand {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tot = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
        bw.write(tot % 12 == 0 ? "12" : (tot % 12 + ""));
        bw.flush();
        bw.close();
        br.close();
    }
}
