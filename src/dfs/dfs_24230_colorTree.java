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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24230
 * 2. 풀이
 *  - 문제에 따르면 흰색으로 다시 칠할 수는 없으며 노드를 칠할 경우, 해당 노드와 자식노드의 색깔이 모두 바뀐다고 한다.
 *   > 즉, 부모노드와 자식노드의 색깔이 다를 경우 자식노드의 개수를 카운팅하면된다.
 *
 *  - 첫 제출에 아무리 생각해봐도 틀린게 없는 로직인데 ....
 *    > 다시 보니 루트노드가 색칠이 된 경우가 고려되지 않았다...
 */
public class dfs_24230_colorTree {

    static int N;
    static int cnt = 0;

    static int[] color;
    static boolean[] visit;
    static List<Integer>[] adj;

    static void color(int idx) {
        visit[idx] = true;
        for(Integer next : adj[idx]) {
            if(visit[next]) continue;
            if(color[idx] != color[next])
                cnt++;
            color(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        color = new int[N + 1];
        visit = new boolean[N + 1];
        adj = new List[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        color(1);
        if(color[1] != 0)
            cnt++;

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
