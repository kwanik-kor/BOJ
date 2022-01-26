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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/19240
 * 2. 풀이
 *  - 인접한 두 노드는 동맹군으로 할 수가 없다는 것이 포인트.
 *   - 즉 트리의 인접한 두 노드를 서로 다른 색깔로 칠할 수 있는지 여부를 판단하면 되는 문제였다.
 */
public class dfs_19240_toyAlliance {

    static final int TEAM_A = 1, TEAM_B = -1;

    static int N, M;
    static int[] team;
    static List<Integer>[] adj;

    static boolean dfs(int node, int type) {
        team[node] = type;
        if(hasSameTeam(node, type))
            return false;

        boolean ret = true;
        for(Integer next : adj[node]) {
            if(team[next] != 0) continue;
            ret = dfs(next, type * (-1));
            if(!ret) return false;
        }
        return ret;
    }

    static boolean hasSameTeam(int node, int type) {
        for(Integer adjacent : adj[node]) {
            if(team[adjacent] == type)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            adj = new List[N + 1];
            team = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            boolean result = true;
            for(int i = 1; i <= N; i++) {
                if(team[i] == 0)
                    result = dfs(i, TEAM_A);
                if(!result) break;
            }

            bw.write(result? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
