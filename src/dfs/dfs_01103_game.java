package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1103
 * 2. 풀이
 *  - 처음에는 DFS를 진행하면서, 방문한 노드가 발생했을 경우에는 사이클로 판단하고 종료처리를 했다.
 *    > 결과는 당연히 틀렸음
 *  - DP를 쓴다고 쓰면서, 방문한 경로에 대한 취소처리를 하지 않고 있었던 것이다.....
 *    > 가장 길게 이동할 수 있는 각각의 경로에 대해 탐색을 진행해야 하기 때문에 DFS는 합리적인 판단이며,
 *      각 노드에서 다음 지점으로 이동할 때, 방문처리 탐색을 마친 후에는 방문 취소처리를 해주니까 통과함
 *    > DP 공부 좀 더해라............
 */
public class dfs_01103_game {

    static int R, C, ans = 0;
    static boolean isCycle = false;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] map, dp;

    static void dfs(int y, int x, int cnt) {
        if(isCycle) return;

        int dist = map[y][x];
        dp[y][x] = cnt;
        ans = Math.max(ans, cnt);

        for(int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir] * dist;
            int nx = x + dx[dir] * dist;
            if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] == -1 || cnt < dp[ny][nx]) continue;
            if(visit[ny][nx]) {
                isCycle = true;
                return;
            }

            visit[ny][nx] = true;
            dfs(ny, nx, cnt + 1);
            visit[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dp = new int[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = arr[j] == 'H'? -1 : (arr[j] - '0');
            }
        }

        dfs(0, 0, 1);

        bw.write(isCycle? "-1" : (ans + ""));
        bw.flush();
        bw.close();
        br.close();
    }

}
