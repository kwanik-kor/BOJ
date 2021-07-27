package bellmanFord;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/3860
 * 2. 풀이
 *  - 지도 상에 음의 간선이 존재할 수 있기 때문에 벨만 - 포드로 풀어야만 한다.
 *  - 주어진 지도에서 각 노드간의 모든 간선을 추가해주고, 음의 간선이 발견되는 경우 Never를 출력
 */
public class bellman_03860_halloweenGrave {

    static final long INF = 1000000000L;
    static int W, H, G, E;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static long[] nodes;
    static List<Edge> edges;

    static boolean bellman() {
        int N = H * W;
        nodes = new long[N];
        Arrays.fill(nodes, INF);
        nodes[0] = 0;

        boolean isShortened = false;

        for(int i = 1; i <= N; i++) {
            isShortened = false;

            for(Edge edge : edges) {
                if(nodes[edge.start] != INF && nodes[edge.start] + edge.cost < nodes[edge.end]) {
                    nodes[edge.end] = nodes[edge.start] + edge.cost;
                    isShortened = true;
                    if(i == N)
                        return true;
                }
            }

            if(!isShortened)
                break;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W == 0 && H == 0)
                break;

            map = new int[H][W];
            nodes = new long[H * W];
            edges = new ArrayList<>();

            // 묘비
            G = Integer.parseInt(br.readLine());
            while(G-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = -1;
            }

            // 구멍
            E = Integer.parseInt(br.readLine());
            while(E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                map[y1][x1] = -2;
                edges.add(new Edge(y1 * W + x1, y2 * W  + x2, cost));
            }

            // 모든 간선 만들기
            for(int y = 0; y < H; y++) {
                for(int x = 0; x < W; x++) {
                    // 현재 노드가 '묘비 / 구멍' 이거나 도착점이라면 패스
                    if(map[y][x] != 0 || (y == H - 1 && x == W - 1))
                        continue;
                    for(int dir = 0; dir < 4; dir++) {
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];
                        // 이동지점이 묘비거나 out of bound라면 패스
                        if(ny < 0 || nx < 0 || H <= ny || W <= nx || map[ny][nx] == -1)
                            continue;
                        edges.add(new Edge(y * W + x, ny * W + nx, 1));
                    }
                }
            }

            Collections.sort(edges, (a, b) -> a.start - b.start);
            // 음의 사이클이 존재한다면
            if(bellman()) {
                bw.write("Never\n");
            } else if(nodes[H * W - 1] == INF) {
                bw.write("Impossible\n");
            } else {
                bw.write(nodes[H * W - 1] + "\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
