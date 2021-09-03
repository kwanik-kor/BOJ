package bfs;

import java.io.*;
import java.util.*;

public class bfs_08184_guilds {

    static final int K = 1, S = 2, N = 3;

    static int n, m;
    static int[] map;
    static Map<Integer, Set<Integer>> edges = new HashMap<>();

    static void setGuild(int start, int type) {

        for(Integer next : edges.get(start)) {

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getNode(a).add(b);
            getNode(b).add(a);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new HashSet<>());
    }
}
