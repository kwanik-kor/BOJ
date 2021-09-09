package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1058
 * 2. 풀이
 *  - 문제 분류가 dfs로 되어 있으나, 사실 플로이드-와샬을 이용해 각 노드간의 최단 거리가 2 이하인 최대 개수를 구해주면 됨
 */
public class dfs_01058_friend {

    static final int INF = 987654321;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = arr[j] == 'N' ? INF : 1;
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(i != j && map[i][j] <= 2) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
