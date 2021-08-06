package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10552
 * 2. 풀이
 *  - 싫어하는 채널인 경우 다음 채널로 가는 간선이 무조건 하나다.
 *  - 이를 응용해서 그래프의 경로 탐색과 같은 문제로 변환해서 풀이할 수 있음
 */
public class bfs_10552_DOM {

    static int N, M, P;
    static int[] channels;
    static Pensioner[] pensioners;

    static int solve() {
        boolean[] visit = new boolean[M + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(P, 0));
        visit[P] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(channels[now.c] == -1) {
                return now.n;
            }

            int next = pensioners[channels[now.c]].fav;
            if(visit[next]) continue;
            visit[next] = true;
            q.add(new Node(next, now.n + 1));
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        pensioners = new Pensioner[N + 1];
        channels = new int[M + 1];
        Arrays.fill(channels, -1);
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int fav = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());
            pensioners[i] = new Pensioner(fav, hate);
            if(channels[hate] == -1) {
                channels[hate] = i;
            }
        }

        bw.write(solve() + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int c;
        int n;
        public Node(int c, int n) {
            this.c = c;
            this.n = n;
        }
    }

    static class Pensioner {
        int fav;
        int hate;
        public Pensioner(int fav, int hate) {
            this.fav = fav;
            this.hate = hate;
        }
    }
}
