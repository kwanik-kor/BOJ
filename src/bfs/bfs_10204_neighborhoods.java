package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10204
 * 2. 풀이
 *  - BFS를 이용해 노드 간 간선의 길이가 2이하인 노드의 개수를 찾기
 */
public class bfs_10204_neighborhoods {

    static int N, E, start;
    static Map<Integer, List<Integer>> map;

    static int solve() {
        boolean[] visit = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        int cnt = 0;

        int len = 0;
        while(!q.isEmpty()) {
            if(len == 2) break;

            int size = q.size();

            while(size-- > 0) {
                int now = q.poll();
                for(Integer next : map.get(now)) {
                    if(visit[next]) continue;
                    visit[next] = true;
                    q.add(next);
                    cnt++;
                }
            }

            len++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for(int i = 1; i <= N; i++) {
                map.put(i, new ArrayList<>());
            }

            while(E-- > 0) {
                int a = Integer.parseInt(st.nextToken().substring(1));
                int b = Integer.parseInt(st.nextToken().substring(1));
                map.get(a).add(b);
                map.get(b).add(a);
            }

            start = Integer.parseInt(st.nextToken().substring(1));
            bw.write(String.format("The number of supervillains in 2-hop neighborhood of v%d is %d\n", start, solve()));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
