package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10917
 * 2. 풀이
 *  - 단방향 간선을 이용한 목적지까지의 최단거리 구하기 문제~!
 */
public class bfs_10917_yourLife {

    static int N, M;
    static Map<Integer, Set<Integer>> edges = new HashMap<>();

    static int solve() {
        int ret = 0;

        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit.add(1);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int now = q.poll();
                if(now == N)
                    return ret;
                for(Integer next : edges.getOrDefault(now, new HashSet<>()))
                    if(visit.add(next))
                        q.add(next);
            }
            ret++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            getNode(x).add(y);
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new HashSet<>());
    }
}
