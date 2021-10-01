package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1967
 * 2. 풀이
 *  - 루트 노드가 1로 고정되어있다 라는 것을 응용할 수 있음
 *   > 루트노드에서 가장 먼 거리에 위치한 노드를 탐색한다.
 *     >> 해당 노드에서 다시 가장 먼 거리에 위치한 노드를 탐색한다.
 */
public class dfs_01967_treeDiameter {

    static int N, nodeOne = 1, r = 0;
    static int[] dist;
    static boolean[] visit;
    static List<Node>[] edges;

    static void dfs(int node, int d) {
        dist[node] = d;
        visit[node] = true;

        if(r < dist[node]) {
            nodeOne = node;
            r = dist[node];
        }

        for(Node next : edges[node]) {
            if(dist[next.child] == 0 && !visit[next.child])
                dfs(next.child, d + next.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, c));
            edges[b].add(new Node(a, c));
        }

        dfs(1, 0);

        r = 0;
        Arrays.fill(dist, 0);
        Arrays.fill(visit, false);

        dfs(nodeOne, 0);

        bw.write(r + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int child;
        int dist;
        public Node(int child, int dist) {
            this.child = child;
            this.dist = dist;
        }
    }

}
