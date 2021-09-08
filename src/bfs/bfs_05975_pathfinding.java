package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5975
 * 2. 풀이
 *  - 노드의 탐색 시간과 노드의 번호를 저장해두고, 이를 정렬하는 문제
 */
public class bfs_05975_pathfinding {

    static final int INF = 987654321;

    static int N, M;
    static int[] dist;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static List<Node> nodes = new ArrayList<>();

    static void setDist() {
        Queue<Integer> q = new LinkedList<>();
        q.add(M);
        dist[M] = 0;
        nodes.add(new Node(M, 0));

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(dist[next] != INF) continue;
                dist[next] = dist[now] + 1;
                nodes.add(new Node(next, dist[next]));
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

        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            dist[i] = INF;

            map.put(i, new ArrayList<>());
            for(int j = 1; j <= N; j++) {
                int d = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                if(d == 1)
                    map.get(i).add(j);
            }
        }

        setDist();
        Collections.sort(nodes);

        int dist = 0;
        for(Node node : nodes) {
            if(dist != node.dist) {
                dist = node.dist;
                bw.write("\n");
            }
            bw.write(node.n + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node>{
        int n;
        int dist;
        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node a) {
            if(dist == a.dist)
                return n - a.n;
            return dist - a.dist;
        }
    }

}
