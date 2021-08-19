package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16021
 * 2. 풀이
 *  - 모든 페이지를 방문할 수 없으면 'N'
 *  - 이야기의 끝에 해당하는 페이지에 도착할 수 있는 최단거리
 *   > 요렇게 두 개 출력하면 끝
 */
public class bfs_16021_chooseYourOwnPath {

    static final int INF = 987654321;
    static int N;
    static int[] dist;
    static boolean[] endpage;
    static Map<Integer, Set<Integer>> page = new HashMap<>();

    static int solve() {
        Arrays.fill(dist, INF);

        boolean[] visit = new boolean[N + 1];

        Queue<Page> q = new LinkedList<>();
        q.add(new Page(1, 1));
        visit[1] = true;
        dist[1] = 1;
        while(!q.isEmpty()) {
            Page now = q.poll();

            for(Integer next : page.get(now.n)) {
                if(visit[next]) continue;
                visit[next] = true;
                dist[next] = now.cnt + 1;
                q.add(new Page(next, now.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        endpage = new boolean[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            page.put(i, new HashSet<>());
        }

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                endpage[i] = true;
                continue;
            }
            for(int j = 0; j < n; j++) {
                page.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        solve();
        boolean flag = true;
        int ans = INF;
        for(int i = 1; i <= N; i++) {
            if(dist[i] == INF) {
                flag = false;
            }
            if(endpage[i]) {
                ans = Math.min(ans, dist[i]);
            }

        }

        bw.write(flag? "Y\n" : "N\n");
        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Page {
        int n;
        int cnt;
        public Page(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
