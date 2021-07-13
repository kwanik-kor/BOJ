package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 풀이 : https://www.acmicpc.net/problem/17142
 * 2. 풀이
 *  - 유사한 문제인 연구소2(https://www.acmicpc.net/problem/17141)과의 차이점은 아래와 같다.
 *   > 바이러스를 활성화 할 수 있는 자리에는 모두 비활성화 바이러스가 있다.
 *     >> 모두 비활성화된 바이러스로 가득차 있다면 이는 이미 바이러스가 모두 퍼져 있는 상태로 본다.
 *   > 빈 칸(0)의 개수를 BFS를 통해 탐색을 진행할 때마다 줄여주고, 모두 퍼진 경우에는 최소 시간을 갱신해준다.
 *   > 바이러스를 놓을 위치는 Combination으로 결정한다.
 */
public class bfs_17142_lab3 {

    static int N, M;
    static int unInfected = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] copiedMap;

    static int ans = 987654321;
    static List<Point> available;

    static void comb(boolean[] arr, int start, int n, int r) {
        if(r == M) {
            List<Point> activate = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i])
                    activate.add(available.get(i));
            }

            solve(activate);

            return;
        }
        for(int i = start; i < n; i++) {
            arr[i] = true;
            comb(arr, i + 1, n, r + 1);
            arr[i] = false;
        }
    }

    static void solve(List<Point> activated) {
        // 초기화
        copyMap(activated);

        Queue<Point> q = new LinkedList<>();
        q.addAll(activated);

        int time = 0;
        int uninfectedTarget = unInfected;
        while(!q.isEmpty()) {
            if(uninfectedTarget == 0) break;

            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];
                    if(ny < 0 || nx < 0 || N <= ny || N <= nx || copiedMap[ny][nx] == 1 || copiedMap[ny][nx] == 2) continue;
                    if(copiedMap[ny][nx] == 0)
                        uninfectedTarget--;

                    copiedMap[ny][nx] = 2;
                    q.add(new Point(ny, nx));
                }
            }

            time++;
        }
        if(uninfectedTarget == 0)
            ans = Math.min(ans, time);
    }

    static void copyMap(List<Point> activated) {
        copiedMap = new int[N][N];

        for(int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copiedMap[i], 0, N);
        }

        for(Point p : activated) {
            copiedMap[p.y][p.x] = 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        available = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)
                    unInfected++;
                else if(map[i][j] == 2) {
                    available.add(new Point(i, j));
                    map[i][j] = -1;
                }
            }
        }
        if(unInfected == 0) {
            bw.write("0");
        } else {
            comb(new boolean[available.size()], 0, available.size(), 0);
            bw.write((ans == 987654321? -1 : ans) + "");
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
