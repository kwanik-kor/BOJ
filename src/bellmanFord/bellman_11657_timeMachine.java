package bellmanFord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11657
 * 2. 풀이
 *  - 벨만 - 포드 문제의 기본형
 *   >> 단, Underflow 문제로 몇 번이고 출력초과가 발생했다.
 *   >> 이는 음의 간선이 int 의 음의 범위를 넘어서서 발생한 문제였다.
 *   >> long으로 처리해서 해결
 *  - 벨만 - 포드
 *    > 기본적으로 dijkstra 의 아이디어에서 출발
 *    > N - 1번 만큼 간선을 순회하며 최단 거리를 계속해서 갱신하고
 *     마지막으로 한 번 더 간선을 순회했을 때, 거리가 줄어들 경우 이는 음의 순환이 발생하는 case로 판별 가능
 */
public class bellman_11657_timeMachine {

    static final long INF = 987654321L;

    static int N, M;
    static long[] nodes;
    static List<Bus> edges = new ArrayList<>();

    static boolean solve() {
        boolean isShortened = false;

        for(int i = 1; i <= N; i++) {
            isShortened = false;

            for(Bus bus : edges) {
                if(nodes[bus.start] == INF) continue;
                if(nodes[bus.start] + bus.cost < nodes[bus.end]) {
                    nodes[bus.end] = nodes[bus.start] + bus.cost;
                    isShortened = true;
                    if(i == N){
                        return true;
                    }
                }
            }

            if(!isShortened)
                return false;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new long[N + 1];
        Arrays.fill(nodes, INF);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        nodes[1] = 0L;
        if(solve()) {
            bw.write("-1");
        } else {
            for(int i = 2; i <= N; i++) {
                bw.write(nodes[i] == INF? "-1" : (nodes[i] + ""));
                if(i != N)
                    bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Bus {
        int start;
        int end;
        long cost;
        public Bus(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
