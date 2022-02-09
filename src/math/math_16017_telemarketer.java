package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16017
 */
public class math_16017_telemarketer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        if(eightOrNine(a) && eightOrNine(d) && b == c) {
            bw.write("ignore");
        } else {
            bw.write("answer");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean eightOrNine(int n) {
        return n == 8 || n == 9;
    }
}
