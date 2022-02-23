package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24087
 */
public class math_24087_iceCream {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int S = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        if(S <= A) {
            bw.write("250");
        } else {
            int dif = S - A;
            bw.write(250 + (dif / B) * 100 + (dif % B == 0 ? 0 : 100) + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
