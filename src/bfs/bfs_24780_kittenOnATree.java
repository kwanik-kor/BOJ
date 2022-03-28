package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24780
 * 2. 풀이
 *  - bfs 보다는 Tree 구조에 대한 이해에 가까운 문제로써, 재귀로 해결가능
 */
public class bfs_24780_kittenOnATree {

    static int root;
    static int[] tree;
    static StringBuilder sb = new StringBuilder();

    static void solve(int node) {
        sb.append(node).append(" ");
        if(tree[node] == 0)
            return;
        solve(tree[node]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        tree = new int[101];
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) break;

            while(st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                tree[node] = parent;
            }
        }

        solve(N);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
