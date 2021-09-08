package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6188
 * 2. 풀이
 *  - 이진트리 / 부모노드로부터 자식노드까지의 거리 계산
 */
public class bfs_6188_clearColdWater {

    static int N, C;
    static int[][] pipes;
    static int[] dist;

    static void setDist() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < 2; i++) {
                int next = pipes[now][i];
                if(next == 0 || dist[next] != 0) continue;
                dist[next] = dist[now] + 1;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pipes = new int[N + 1][2];
        dist = new int[N + 1];
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b_1 = Integer.parseInt(st.nextToken());
            int b_2 = Integer.parseInt(st.nextToken());
            pipes[a][0] = b_1;
            pipes[a][1] = b_2;
        }

        setDist();

        for(int i = 1; i <= N; i++)
            bw.write(dist[i] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
