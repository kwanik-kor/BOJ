package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/20166
 * 2. 풀이
 *  - 신이 좋아하는 문자열은 중복될 수도 있으며 최대 1000개의 쿼리를 만들어낼 수 있다.
 *   > 즉, 쿼리마다 탐색을 실행할 경우에 시간초과가 발생할 것이다.
 *    > 이에, 만들어질 수 있는 문자열과 그 경우의 수를 미리 만들어두고
 *      쿼리에 대응해야만 해결이 가능할 것으로 판단했다...
 *       >> 근데 가장 빠른 풀이를 조회해보니.. 쿼리마다 돌려도 가능하네..? O(N) 다시 공부해라
 *  - 쿼리 문자열의 길이에 대한 언급은 없었으며, 최대 5의 길이를 갖기 때문에 5번까지의 경로탐색을 진행해주면 된다.
 */
public class dfs_20166_stringHell {

    static int N, M, K;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static char[][] map;
    static Map<String, Integer> ans;

    static void dfs(int y, int x, String str) {
        updateCount(str);

        if(str.length() == 5)
            return;

        for(int dir = 0; dir < 8; dir++) {
            int ny = (y + dy[dir] < 0)? N - 1 : (y + dy[dir] == N? 0 : y + dy[dir]);
            int nx = (x + dx[dir] < 0)? M - 1: (x + dx[dir] == M? 0 : x + dx[dir]);
            dfs(ny, nx, str + map[ny][nx]);
        }
    }

    static void updateCount(String str) {
        ans.put(str, ans.computeIfAbsent(str, k -> 0) + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        ans = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dfs(i, j, String.valueOf(map[i][j]));
            }
        }

        for(int q = 0; q < K; q++) {
            String query = br.readLine();
            bw.write(ans.getOrDefault(query, 0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
