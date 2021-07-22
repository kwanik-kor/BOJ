package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5237
 * 2. 풀이
 *  - 연결된 노드의 개수가 전체 노드의 개수와 일치하는지 파악하면 됨
 */
public class bfs_05237_connected {

    static int N;
    static Map<Integer, List<Integer>> map;

    static boolean solve() {
        HashSet<Integer> set = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(set.contains(next)) continue;
                set.add(next);
                q.add(next);
            }
        }

        return set.size() == N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                map.put(i, new ArrayList<>());
            }

            for(int i = 0; i < k; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.get(a).add(b);
                map.get(b).add(a);
            }

            bw.write(solve()? "Connected.\n" : "Not connected.\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
