package floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6207
 * 2. 풀이
 *  - 플로이드-와샬을 이용해 N -> M 으로 이동가능한지 확인
 */
public class floyd_6207_cowPicnic {

    static final int INF = 987654321;

    static int K, N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<Integer> pastures = new HashSet<>();
        for(int i = 0; i < K; i++)
            pastures.add(Integer.parseInt(br.readLine()));

        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 0;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            boolean can = true;
            for(Integer start : pastures) {
                if(map[start][i] == INF) {
                    can = false;
                    break;
                }
            }
            if(!can) continue;
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
