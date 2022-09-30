package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25644
 * 2. 풀이
 *  - 무조건 최소값과 이후 나오는 최대값 정답 산정 기준으로 가져가면 안됨
 *  - 입력되는 값을 루프를 돌며 최소값이 등장하는 경우 최소값을 항상 갱신해준다.
 *  - 최대치(답)의 경우, 새로 입력들어오는 값과 기존 최대값 중 최대값을 선택한다.
 *  - O(N)으로 풀이 가능
 *  - 주의해야 할 반례
 *    - 4
 *    - 5 1000 1 4
 */
public class dp_25644_maxRaise {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int ret = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val < min) {
                min = val;
            } else {
                ret = Math.max(ret, val - min);
            }
        }
        bw.write(ret + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
