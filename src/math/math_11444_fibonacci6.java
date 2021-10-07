package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11444
 * 2. 풀이
 *  - 도가뉴의 항등식 : F(n+m) = F(n) * F(m + 1) + F(n - 1) * F(m)
 *   > 항등식 증명 참고 : https://mathpeak.tistory.com/445
 *  - 도가뉴 항등식과 메모이제이션을 이용해서 해결
 */
public class math_11444_fibonacci6 {

    static final long DIV = 1000000007;
    static long N;
    static Map<Long, Long> dp;

    static long fibo(long idx) {
        if(idx == 0) return 0;
        else if(idx == 1) return 1;

        if(dp.get(idx) != null)
            return dp.get(idx);

        if(idx % 2 == 0) {
            long a = fibo(idx / 2 - 1) % DIV;
            long b = fibo(idx / 2) % DIV;

            dp.put(idx, (b * (2 * a + b)) % DIV); 
            return dp.get(idx);
        }

        long a = fibo(idx / 2 + 1) % DIV;
        long b = fibo(idx / 2) % DIV;

        dp.put(idx, (a * a + b * b) % DIV);
        return dp.get(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());
        dp = new HashMap<>();

        bw.write(fibo(N) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
