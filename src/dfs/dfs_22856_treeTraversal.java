package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/22856
 * 2. 풀이
 *  - 중위탐색을 진행할 때, child 노드로 이동할 때는 움직임 횟수를 증가시켜준다.
 *  - 다시 올라오는 것이 이번 문제의 핵심
 *    > child 노드까지 탐색후에, 모든 노드를 탐색하지 않았고 그래프의 Root(1번 노드)가 아니라면 다시 올라가는 횟수를 추가해줌
 */
public class dfs_22856_treeTraversal {

    static int N, nodeCnt = 0, moveCnt = 0;
    static int[] dist;
    static Node[] nodes;

    static void dfs(int node) {
        if(nodes[node].l != -1) {
            moveCnt++;
            dfs(nodes[node].l);
        }

        nodeCnt++;

        if(nodes[node].r != -1) {
            moveCnt++;
            dfs(nodes[node].r);
        }

        if(node != 1 && nodeCnt != N)
            moveCnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        dist = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodes[node] = new Node(l, r);
        }

        dfs(1);

        bw.write(moveCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int l, r;
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
