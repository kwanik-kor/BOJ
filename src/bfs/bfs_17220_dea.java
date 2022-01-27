package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17220
 * 2. 풀이
 *  - 방문하지 못하는 노드에 대해 선행으로 처리해두는 것과 루트 노드를 판단하는 것이 주요한 이슈였던 문제다.
 *   - 방문할 수 없는 노드를 제외하고 노드를 방문할 경우 count up 해주면 됨!
 *  - 왜 Gold 4인가여..?
 */
public class bfs_17220_dea {

    static int N, M;
    static int[] origin;
    static List<Integer>[] adj;

    static boolean[] visit;

    static int search(int idx) {
        int ret = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(idx);
        visit[idx] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : adj[now]) {
                if(visit[next]) continue;
                visit[next] = true;
                ret++;
                q.add(next);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N];
        origin = new int[N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            adj[a].add(b);
            origin[b]++;
        }

        st = new StringTokenizer(br.readLine());
        int caught = Integer.parseInt(st.nextToken());
        for(int i = 0; i < caught; i++) {
            visit[st.nextToken().charAt(0) - 'A'] = true;
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(origin[i] == 0 && !visit[i]) {
                ans += search(i);
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
