package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17945
 * 2. 풀이 
 * - 근의공식
 */
public class math_17945_god {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int flag = (int) Math.sqrt(b * b - c);
        int ans_1 = (-1) * b + flag;
        int ans_2 = (-1) * b - flag;
        if (ans_1 == ans_2) {
            bw.write(ans_1 + "");
        } else {
            bw.write(ans_1 < ans_2 ? (ans_1 + " " + ans_2) : (ans_2 + " " + ans_1));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
