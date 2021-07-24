package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5938
 * 2. 풀이
 *  - 그래프에서 1번 노드와 연결되지 않은 노드들을 찾는 문제
 *    > BFS 한방이면 해결!
 */
public class bfs_05938_daisyChain {

    static int N, M;
    static boolean[] visit;
    static Map<Integer, List<Integer>> map;

    static void solve() {
        visit = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(visit[next]) continue;
                visit[next] = true;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        solve();

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                bw.write(i + "\n");
                cnt++;
            }
        }
        if(cnt == 0)
            bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }
}
