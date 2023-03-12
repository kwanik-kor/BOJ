package math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2745
 */
public class math_02745_changeArithmetics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(Integer.parseInt(st.nextToken(), Integer.parseInt(st.nextToken())) + "");
        bw.close();
        br.close();
    }
}
