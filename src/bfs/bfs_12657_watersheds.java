package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12657
 * 2. 풀이
 *  - Sink를 먼저 선정해두고, 영역이 지정되지 않은 노드들을 순차적으로 움직여서 영역을 지정해줌
 *  - 정답이 알파벳 순으로 출력되야 하기 때문에 마지막에 라벨링 작업을 해줌
 */
public class bfs_12657_watersheds {

    static final int MAX = 10001;

    static int H, W;
    static int sinkIdx;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    static int[][] map;
    static int[][] area;

    static void setArea(int y, int x) {
        Point start = new Point(y, x);

        List<Point> path = new ArrayList<>();
        path.add(start);

        Queue<Point> q = new LinkedList<>();
        q.add(start);

        int areaNo = 0;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(area[now.y][now.x] != 0) {
                areaNo = area[now.y][now.x];
                break;
            }

            int altitude = map[now.y][now.x];

            Point next = null;
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(map[ny][nx] < altitude) {
                    next = new Point(ny, nx);
                    altitude = map[ny][nx];
                }
            }

            if(next != null) {
                q.add(next);
                path.add(next);
            }
        }

        for(Point p : path) {
            area[p.y][p.x] = areaNo;
        }

    }

    static void findSink() {
        for(int j= 1; j <= W; j++) {
            for(int i = 1; i <= H; i++) {
                boolean flag = true;

                for(int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(map[ny][nx] < map[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    area[i][j] = sinkIdx++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new int[H + 2][W + 2];
            area = new int[H + 2][W + 2];
            sinkIdx = 1;
            for(int y = 0; y < H + 2; y++) {
                map[y][0] = MAX;
                map[y][W + 1] = MAX;
            }

            for(int x = 0; x < W + 2; x++) {
                map[0][x] = MAX;
                map[H + 1][x] = MAX;
            }

            for(int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Solve
            findSink();

            for(int j = 1; j <= W; j++) {
                for(int i = 1; i <= H; i++) {
                    if(area[i][j] == 0)
                        setArea(i, j);
                }
            }

            int[] label = new int[27];
            int idx = 1;
            for(int i = 1; i <= H; i++) {
                for(int j = 1; j <= W; j++) {
                    if(label[area[i][j]] != 0) continue;
                    label[area[i][j]] = idx++;
                }
            }

            bw.write(String.format("Case #%d:\n", t));
            for(int i = 1; i <= H; i++) {
                for(int j = 1; j <= W; j++) {
                    bw.write((char)(label[area[i][j]] - 1 + 'a') + " ");
                }
                bw.write("\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
