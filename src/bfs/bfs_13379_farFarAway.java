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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13379
 * 2. 풀이
 *  - 각 노드에 도착할 수 있는 최장거리가 Threshold 이상이지 않을 경우 -1로 처리
 */
public class bfs_13379_farFarAway {

    static int C, M;
    static int[] dest;
    static List<Node>[] edges;

    static int solve() {
        int ret = -1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        dest[1] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(Node next : edges[now.n]) {
                dest[next.n] = dest[now.n] + next.dist;
                ret = Math.max(ret, dest[next.n]);
                q.add(next);
            }
        }

        return M <= ret? ret : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken()); // number of cities
            M = Integer.parseInt(st.nextToken()); // pickiness threshold

            edges = new List[C + 1];
            dest = new int[C + 1];
            for(int i = 1; i <= C; i++) {
                edges[i] = new ArrayList<>();
                dest[i] = -1;
            }

            for(int i = 0; i < C - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges[a].add(new Node(b, c));
            }

            bw.write(solve() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int n;
        int dist;
        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
}
