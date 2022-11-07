package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14471
 * 2. Greedy Algorithm
 *  - input 을 받으면서 당첨된 포인트카드가 M - 1 개 이상이라면 더 이상 로직을 수행할 필요가 없음
 *  - input 의 당첨 개수를 기준으로 내림차순 정렬을 해, 최대한 적은 비용으로 당첨 개수를 늘리게 조치
 */
public class greedy_14471_pointCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][2];
        int winCnt = 0;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 당첨
            arr[i][1] = Integer.parseInt(st.nextToken()); // 실패
            if (arr[i][0] >= N) {
                winCnt++;
            }
        }

        if (winCnt >= M - 1) {
            bw.write("0");
        } else {
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            });

            for (int i = 0; i < M; i++) {
                if (arr[i][0] >= N) continue;
                cnt += N - arr[i][0];
                winCnt++;

                if (winCnt >= M - 1) {
                    break;
                }
            }
            bw.write(cnt + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
