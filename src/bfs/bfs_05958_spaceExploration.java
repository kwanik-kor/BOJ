package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5958
 * 2. 풀이
 *  - BFS 를 이용한 구역 나누기
 */
public class bfs_05958_spaceExploration {

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static void setArea(Integer start, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        map[start / N][start % N] = n;

        while(!q.isEmpty()) {
            int now = q.poll();
            int y = now / N;
            int x = now % N;
            for(int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] != 0) continue;
                map[ny][nx] = n;
                q.add(ny * N + nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        List<Integer> asteroids = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(tmp[j] == '.')
                    map[i][j] = -1;
                else
                    asteroids.add(i * N + j);
            }
        }
        int ret = 0;
        for(Integer as : asteroids) {
            if(map[as / N][as % N] == 0)
                setArea(as, ++ret);
        }

        bw.write(ret + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
