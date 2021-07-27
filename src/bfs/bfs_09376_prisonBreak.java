package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9376
 * 2. 풀이
 *  - 엄청난 대삽질 끝에 결국 힌트를 얻어서 푼 문제
 *   - 바깥에서 들어와보기도 하고, 안에서 두 범인을 동시에 움직여도 봤으나....
 *     바깥 / 죄수 1 / 죄수 2 를 각각 움직여서 문을 열어야 하는 횟수를 모두 더했을 때
 *     즉, 세 명이 모이는 한 점의 최솟값이 바로 정답이었음!!!
 *
 *   - 단, 만나는 지점이 문인 경우에 세 명다 문을 열어제끼기 때문에, -2 를 해줘야함
 */
public class bfs_09376_prisonBreak {

    static final int INF = 987654321;

    static int H, W;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static int[][][] dist;
    static Point[] startPoints;

    static void solve() {
        dist = new int[3][H + 2][W + 2];
        for(int n = 0; n < 3; n++) {
            for(int i = 0; i < H + 2; i++) {
                Arrays.fill(dist[n][i], INF);
            }

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.add(startPoints[n]);
            dist[n][startPoints[n].y][startPoints[n].x] = 0;

            while(!pq.isEmpty()) {
                Point now = pq.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];
                    if(ny < 0 || nx < 0 || H + 2 <= ny || W + 2 <= nx || dist[n][ny][nx] != INF || map[ny][nx] == -1) continue;
                    int doorCnt = map[ny][nx] == 1? now.n + 1 : now.n;
                    dist[n][ny][nx] = doorCnt;
                    pq.add(new Point(ny, nx, doorCnt));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new int[H + 2][W + 2];
            startPoints = new Point[3];
            startPoints[0] = new Point(0, 0, 0);
            int idx = 0;

            for(int i = 0; i < H; i++) {
               char[] arr = br.readLine().toCharArray();
               for(int j = 0; j < W; j++) {
                   if(arr[j] == '*') {
                       map[i + 1][j + 1] = -1;
                   } else if(arr[j] == '#') {
                       map[i + 1][j + 1] = 1;
                   } else if(arr[j] == '$') {
                       map[i + 1][j + 1] = 2;
                       startPoints[++idx] = new Point(i + 1, j + 1, 0);
                   }
               }
            }

            solve();

            int ans = INF;
            for(int i = 0; i < H + 2; i++) {
                for(int j = 0; j < W + 2; j++) {
                    if(map[i][j] == -1 || dist[0][i][j] == INF) continue;
                    ans = Math.min(ans, dist[0][i][j] + dist[1][i][j] + dist[2][i][j] + (map[i][j] == 1? -2 : 0));
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
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
