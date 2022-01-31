package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bfs_17197_fencePlanning {

    static int N, M;
    static int[] parent;
    static List<Cow> cows = new ArrayList<>();

    static int find(int n) {
        if(n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

    static void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            a = find(a);
            b = find(b);
            if(a != b) {
                merge(a, b);
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println(i + " --> " + parent[i]);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Cow {
        int y, x;
        public Cow(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
