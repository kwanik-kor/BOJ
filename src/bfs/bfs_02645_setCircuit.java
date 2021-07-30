package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2645
 * 2. 풀이
 *  - 처음에 회로가 겹쳐있는 경우에 (겹쳐 있는 수 x K)만큼 cost가 발생하는 줄 알고,
 *   계속 그렇게 넣다가 다시보니... 겹쳐있는것과 관계 없이 cost는 회로가 있다면 항상 K....
 *   >> 문제 제대로 안보냐!!!!!!!!!!!!!!!!!!!!
 *  - 아무튼, cost 정리만 해두고 PriorityQueue를 이용한 경로 탐색과 경로 역추적만 잘 해내면
 *   문제 없이 풀 수 있음
 */
public class bfs_02645_setCircuit {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0 ,-1};

    static int[][] map;
    static int[][] dist;

    static Point start, end;
    static int[] path;

    static void solve() {
        path = new int[N * N];
        Arrays.fill(path, -1);

        dist = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[start.y][start.x] = 1;
        path[start.y * N + start.x] = start.y * N + start.x;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(start);

        while(!pq.isEmpty()) {
            Point now = pq.poll();
            if(now.y == end.y && now.x == end.x) {
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];

                if(ny < 0 || nx < 0 || N <= ny || N <= nx) continue;

                int nn = dist[now.y][now.x] + map[ny][nx];
                if(dist[ny][nx] <= nn) continue;

                dist[ny][nx] = nn;
                path[ny * N + nx] = now.y * N + now.x;
                pq.add(new Point(ny, nx, nn));
            }
        }
    }

    static void setExistingCircuit(Point a, Point b) {
        int startY = Math.min(a.y, b.y);
        int startX = Math.min(a.x, b.x);
        int endY = Math.max(a.y, b.y);
        int endX = Math.max(a.x, b.x);

        for(int i = startY; i <= endY; i++) {
            for(int j = startX; j <= endX; j++) {
                map[i][j] = K;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        // 시작점, 도착점
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 1);
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        // 비용
        K = Integer.parseInt(br.readLine());

        // 기존 회로
        map = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(map[i], 1);

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());
            Point[] circuits = new Point[nodeCnt];

            for(int i = 0; i < nodeCnt; i++) {
                circuits[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
                if(i != 0)
                    setExistingCircuit(circuits[i - 1], circuits[i]);
            }
        }

        solve();

        bw.write(dist[end.y][end.x] + "\n");

        StringBuffer sb = new StringBuffer("");
        int cnt = 2;
        int endIdx = end.y * N + end.x;
        int startIdx = path[endIdx];
        boolean isVertical = endIdx % N == startIdx % N;

        sb.append(indexToPointString(endIdx));
        while(endIdx != startIdx) {
            boolean tempVertical = endIdx % N == startIdx % N;
            // 방향이 같지 않다면 출력에 추가
            if(!(isVertical && tempVertical || !isVertical && !tempVertical)) {
                cnt++;
                sb.insert(0, indexToPointString(endIdx));
            }

            endIdx = startIdx;
            startIdx = path[endIdx];
            isVertical = tempVertical;
        }
        sb.insert(0, (start.y + 1) + " " + (start.x + 1) + " ");

        bw.write(cnt + " " + sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static String indexToPointString(int idx) {
        return (idx / N + 1) + " " + (idx % N + 1) + " ";
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int n;

        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }

        @Override
        public int compareTo(Point p) {
            return this.n - p.n;
        }
    }
}
