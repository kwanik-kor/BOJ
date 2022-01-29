package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1113
 * 2 .풀이
 *  - 제공된 지도에 물을 가득 채우고, 위에서부터 제시된 조건에 맞게 물을 제거하는 작업을 수행한다.
 */
public class bfs_01113_makeSwimmingPool {

    static final int WALL = 1, WATER = 2;

    static int N, M;
    static int max_height = 0, min_height = 10;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static int[][] water;
    static boolean[][] visit;

    static void setWater(int y, int x, int h) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visit[y][x] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            water[now.y][now.x]--;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(outOfRange(ny, nx) || visit[ny][nx]) continue;
                if(map[ny][nx] + water[ny][nx] == h && water[ny][nx] > 0) {
                    visit[ny][nx] = true;
                    q.add(new Node(ny, nx));
                }

            }
        }
    }

    static int solve() {
        for(int h = max_height; h > min_height; h--) {
            initVisit();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(canWaterFall(i, j)) {
                        setWater(i, j, h);
                    }
                }
            }
        }

        int ret = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                ret += water[i][j];
            }
        }

        return ret;
    }

    static void initVisit() {
        for(int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }
    }

    static boolean canWaterFall(int y, int x) {
        if(water[y][x] == 0 || visit[y][x])
            return false;

        for(int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(outOfRange(ny, nx))
                return true;

            if(map[ny][nx] + water[ny][nx] < map[y][x] + water[y][x]) {
                return true;
            }
        }

        return false;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || N <= y || x < 0 || M <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        water = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                max_height = Math.max(max_height, map[i][j]);
                min_height = Math.min(min_height, map[i][j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                water[i][j] = max_height - map[i][j];
            }
        }

        int ans = solve();

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
