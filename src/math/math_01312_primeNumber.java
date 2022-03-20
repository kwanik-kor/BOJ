package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1312
 */
public class math_01312_primeNumber {

    static int A, B, N;

    static int find(int remainder, int lastNo, int cnt) {
        if(cnt == N)
            return lastNo;

        int mok = remainder * 10 / B;
        int r = remainder * 10 % B;
        return find(r, mok, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int ans = find(A % B, 0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
