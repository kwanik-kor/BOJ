package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13700
 * 2. 풀이
 *  - 문제를 꼼꼼히 읽읍시다.......
 *    > 경찰서가 없으면 두 번째 줄이 주어지지 않음!!!!!!!!!!
 */
public class bfs_13700_completeCrime {

    static final int INF = 987654321;

    static int N, S, D, F, B, K;
    static int[] direction = {-1, 1};
    static int[] mount = new int[2];

    static int[] visit;

    static int solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visit[S] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == D)
                return visit[D];
            for(int dir = 0; dir < 2; dir++) {
                int next = now + direction[dir] * mount[dir];
                if(next < 1 || N < next || visit[next] != INF) continue;
                visit[next] = visit[now] + 1;
                q.add(next);
            }
        }

        return INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];
        mount[0] = B;
        mount[1] = F;
        Arrays.fill(visit, INF);
        // 경찰서는 이미 방문한 노드로 처리
        if(K != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++) {
                visit[Integer.parseInt(st.nextToken())] = -1;
            }
        }

        if(visit[S] == -1 || visit[D] == -1)
            bw.write("BUG FOUND");
        else {
            int ans = solve();
            bw.write(ans == INF? "BUG FOUND" : (ans + ""));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
