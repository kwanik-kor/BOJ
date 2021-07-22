package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17198
 * 2. 풀이
 *  - BFS로 경로찾는 가장 단순한 문제
 *   > 최종 목적지로 향하는 길이 1만큼은 빼줘야 함
 */
public class bfs_17198_bucketBrigade {

    static int start, end;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visit;

    static int solve() {
        int ret = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start / 10][start % 10] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int now = q.poll();
                int y = now / 10;
                int x = now % 10;

                if(now == end)
                    return ret - 1;

                for(int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(ny < 0 || nx < 0 || 10 <= ny || 10 <= nx || visit[ny][nx] || map[ny][nx] == 'R') continue;
                    visit[ny][nx] = true;
                    q.add(ny * 10 + nx);
                }
            }

            ret++;
        }


        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new char[10][10];
        visit = new boolean[10][10];

        for(int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < 10; j++) {
                if(map[i][j] == 'B')
                    start = i * 10 + j;
                else if(map[i][j] == 'L')
                    end = i * 10 + j;
            }
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
