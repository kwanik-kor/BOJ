package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5220
 */
public class math_05220_errorDetection {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr = Integer.toBinaryString(Integer.parseInt(st.nextToken())).toCharArray();
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] == '0'? 0 : 1;
            }
            bw.write(cnt % 2 == Integer.parseInt(st.nextToken())? "Valid\n" : "Corrupt\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
