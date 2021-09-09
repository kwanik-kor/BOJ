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

public class bfs_21325_freeFood {

    static int N, M;
    static int[] level;
    static List<Integer>[] edges;

    static void setLevel(int ceo) {
        Queue<Integer> q = new LinkedList<>();
        level[ceo] = 0;
        q.add(ceo);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : edges[now]) {
                if(level[next] != -1) continue;
                level[next] = level[now] + 1;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        level = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            level[i] = -1;
        }

        st = new StringTokenizer(br.readLine());
        int CEO = 0;
        for(int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(boss == 0)
                CEO = i;
            else {
                edges[boss].add(i);
            }
        }

        setLevel(CEO);

        bw.flush();
        bw.close();
        br.close();
    }
}
