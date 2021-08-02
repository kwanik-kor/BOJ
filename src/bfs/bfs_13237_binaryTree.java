package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13237
 * 2. 풀이
 *  - BFS 알고리즘의 개념을 가장 직관적으로 이해할 수 있는 문제
 *  - 풀이에 어려움은 없음
 */
public class bfs_13237_binaryTree {

    static int N, root;
    static int[] depth;
    static Map<Integer, Set<Integer>> map;

    static void setDepth() {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        depth[root] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(depth[next] != -1) continue;
                depth[next] = depth[now] + 1;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        depth = new int[N + 1];
        map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
            depth[i] = -1;
        }

        for(int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(br.readLine());
            if(parent == -1) {
                root = i;
                continue;
            }
            map.get(parent).add(i);
        }

        setDepth();

        for(int i = 1; i <= N; i++) {
            bw.write(depth[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

