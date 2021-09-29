package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21325
 * 2. 풀이
 *  - 반드시 같은 레벨의 노드들이 정답의 대상이 되지는 않음 다시 푸셈!!!!
 *   > BFS로 동일한 레벨의 노드들만 탐색해서 처음 풀이 때 틀렸음.
 *
 *  - '트리 / 트리 DP' 문제를 풀이 후, 해당 문제는 트리 DP를 이용해 풀이할 수 있겠단 생각이 들었음
 *   > CEO를 기점으로 자식 노드들을 향한 단방향 트리이기 때문에 굳이 방문처리를 진행할 필요는 없음
 *
 *  - 부모 노드가 '자리에 참석 중'이라면, 아래 자식노드들을 탐색할 필요 없이 해당 트리는 '한 명'의 식대를 지불할 사람이 생김
 *   > 반면, 부모가 자리에 참석 중이지 않다면 자식 노드들 중에서 위 과정을 거쳐 첫 번째로 만나는(참석한) 부모 노드들의 개수를 세면 됨
 */
public class dfs_21325_freeFood {

    static int N, M, CEO;
    static boolean[] present;
    static int[] dp;
    static List<Integer>[] edges;

    static void solve(int n) {
        if(present[n]) {
            dp[n] = 1;
            return;
        }

        for(Integer child : edges[n]) {
            solve(child);
            dp[n] += dp[child];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        dp = new int[N + 1];
        present = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(boss != 0)
                edges[boss].add(i);
            else
                CEO = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            present[Integer.parseInt(st.nextToken())] = true;

        solve(CEO);

        bw.write(dp[CEO] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
