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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/20924
 * 2. 풀이
 *  - 양방향 간선으로 트리를 구성해두고 루트 부터 DFS를 진행했을 때, 방문할 수 있는 노드가 2개 이상이 되면
 *    해당 노드를 '기가 노드'로 선정하고 해당 노드까지의 거리를 반환
 *  - 기가 노드로부터 각 리프노드까지의 거리를 DFS를 이용해 MAX 거리를 반환
 */
public class dfs_20924_treePillarBranch {

    static int N, R, giga;
    static boolean[] visit;
    static List<Node>[] edges;

    static int findGiga(int node) {
        int ret = 0;

        visit[node] = true;
        giga = node;

        int nextNodeCnt = 0;
        for(Node next : edges[node]) {
            if(!visit[next.v])
                nextNodeCnt++;
            if(nextNodeCnt > 1)
                return ret;
        }

        for(Node next : edges[node]) {
            if(!visit[next.v])
                ret += next.e + findGiga(next.v);
        }

        return ret;
    }

    static int findBranch(int node) {
        int ret = 0;

        visit[node] = true;
        for(Node next : edges[node]) {
            if(!visit[next.v])
                ret = Math.max(ret, next.e + findBranch(next.v));
        }

        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        edges = new List[N + 1];
        for(int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, c));
            edges[b].add(new Node(a, c));
        }

        int pillar = findGiga(R);
        int branch = findBranch(giga);

        bw.write(pillar + " " + branch);
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int v;
        int e;
        public Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }
}
