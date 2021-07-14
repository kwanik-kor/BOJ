package greedy;

import java.io.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/19940
 * 2. 풀이
 *  - 그리디 알고리즘을 통해 적절하게 주어진 버튼들로 결과를 만들어 내야 한다.
 *  - 기본적으로 60초의 단위가 가장 크기 때문에, N을 60으로 나눈 몫 만큼 60초 버튼을 누르고
 *    나머지가 35보다 크다면, 한 번 더 눌러서 빼는 경우가 더 효율적이다.
 *  - 10초 단위도 60초와 마찬가지로 진행한다.
 */
public class greedy_19940_pizzaOven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] ans;

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ans = new int[5];

            ans[0] += N / 60;
            N %= 60;

            if(N <= 35) {
                // 10, 1, -1
                ans[1] += N / 10;
                if(N % 10 <= 5) {
                    ans[3] += N % 10;
                } else {
                    ans[1]++;
                    ans[4] += 10 - N % 10;
                }
            } else {
                N = 60 - N;
                ans[0]++;
                ans[2] += N / 10;
                if(N % 10 <= 5) {
                    ans[4] += N % 10;
                } else {
                    ans[2]++;
                    ans[3] += 10 - N % 10;
                }
            }

            for(int i = 0; i < 5; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
