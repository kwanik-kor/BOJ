package bfs;

import java.io.*;
import java.util.*;

public class bfs_24447_알고리즘수업_너비우선탐색4 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Map<Integer, Set<Integer>> map = new HashMap<>();

    static long solve(int start, long[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        int idx = 1;
        long tot = visited[start] * idx;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (!map.containsKey(cur)) continue;

            for (Integer next : map.get(cur)) {
                if (visited[next] != -1) continue;

                visited[next] = visited[cur] + 1;
                q.add(next);
                tot += visited[next] * (++idx);
            }
        }

        return tot;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[] visited = new long[N + 1];
        Arrays.fill(visited, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(node, k -> new TreeSet<>()).add(target);
            map.computeIfAbsent(target, k -> new TreeSet<>()).add(node);
        }

        bw.write(solve(R, visited) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
