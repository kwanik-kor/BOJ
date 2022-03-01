package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21354
 */
public class math_21354_appleAndPear {

    static final int APPLE = 7, PEAR = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int apple = Integer.parseInt(st.nextToken()) * APPLE;
        int pear = Integer.parseInt(st.nextToken()) * PEAR;

        if(apple < pear) bw.write("Petra");
        else if (apple > pear) bw.write("Axel");
        else bw.write("lika");

        bw.flush();
        bw.close();
        br.close();
    }
}
