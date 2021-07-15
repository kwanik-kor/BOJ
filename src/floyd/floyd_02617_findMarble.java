package floyd;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2617
 * 2. 풀이
 *  - 모든 구슬에 대해 무게를 체크해야 하기 때문에, 플로이드-와샬 을 이용해 관계를 만들어 놓음
 *  - 가볍거나 무거운 개수가 (N - 1) / 2 보다 큰 경우 중간이 절대 될 수 없음
 */
public class floyd_02617_findMarble {

    static final int INF = 987654321;

    static int N, M;
    static int[][] map;

    static void floyd() {
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][k] == -1 && map[k][j] == -1) {
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
            for(int j = 0; j <= N; j++) {
                if(i == j) map[i][j] = 0;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = -1;
        }

        floyd();

        int ans = 0;
        int flag = (N - 1) / 2;
        for(int n = 1; n <= N; n++) {
            int light = 0;
            int heavy = 0;
            for(int i = 1; i <= N; i++) {
                if(map[n][i] == -1)
                    heavy++;
                if(map[n][i] == 1)
                    light++;
            }
            if(flag < light || flag < heavy)
                ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
