package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6755
 * 2. 풀이
 *  - p를 기준점으로 bfs를 한 번 만 수행한다면 답을 찾을 수 없음
 */
public class bfs_06755_whoIsTaller {

    static int N, M, p, q;
    static List<Integer>[] adj;

    static boolean solve(int start, int end) {
        Set<Integer> visit = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : adj[now]) {
                if(visit.contains(next)) continue;
                if(next == end) return true;

                visit.add(next);
                q.add(next);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
        }

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()) - 1;
        q = Integer.parseInt(st.nextToken()) - 1;

        if(solve(p, q))
            bw.write("yes");
        else if(solve(q, p))
            bw.write("no");
        else
            bw.write("unknown");


        bw.flush();
        bw.close();
        br.close();
    }
}
