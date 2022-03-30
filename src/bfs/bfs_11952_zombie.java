package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11952
 * 2. 풀이
 *  - 거리에 따른 위험한 도시 설정을 먼저 진행하고,
 *    우선순위 큐와 다익스트라 개념을 이용하여 최단 비용 루트를 산출한다.
 */
public class bfs_11952_zombie {

    static final char INFECTED = 'Z', VISIT = 'V', DANGEROUS = 'D';

    static int N, M, K, S;
    static long P, Q;
    static char[] cities;
    static List<Integer>[] adj;

    static long bfs() {
        long[] visit = new long[N + 1];
        Arrays.fill(visit, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0L));
        visit[1] = 0L;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            for(Integer next : adj[now.n]) {
                if(cities[next] == INFECTED) continue;
                long nextCost = now.cost + (next == N? 0 : (cities[next] == DANGEROUS ? Q : P));
                if(nextCost < visit[next]) {
                    visit[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }

        return visit[N];
    }

    static void setDangerousCity(List<Integer> infectedCities) {
        if(infectedCities.isEmpty()) return;

        Queue<Integer> q = new LinkedList<>(infectedCities);

        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int now = q.poll();
                for(Integer next : adj[now]) {
                    if(cities[next] == DANGEROUS || cities[next] == INFECTED) continue;
                    cities[next] = DANGEROUS;
                    q.add(next);
                }
            }
            dist++;
            if(S < dist)
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        cities = new char[N + 1];
        adj = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 좀비 도시
        List<Integer> infectedCities = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            int city = Integer.parseInt(br.readLine());
            cities[city] = INFECTED;
            infectedCities.add(city);
        }
        // 간선 연결
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        setDangerousCity(infectedCities);

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int n;
        long cost;
        public Node(int n, long cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.cost - o.cost);
        }
    }
}
