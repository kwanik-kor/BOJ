package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18405
 * 2. 풀이
 *  - 바이러스 번호가 낮은 것 부터 퍼지기 때문에,
 *   바이러스 정보를 모두 받아서 바이러스 번호가 낮은 순서대로 정렬을 한 번 해줌
 *  - 정렬된 바이러스 정보를 모두 큐에 넣고, 시간 별로 순차적으로 BFS 순회를 시작
 *  - 어차피 바이러스가 증식된 곳에 다른 바이러스가 들어가지는 못하기 때문에
 *    end point에 도착한 경우에는 조기 리턴
 */
public class bfs_18405_competitiveInfection {

    static int N, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static Point end;

    static int solve(List<Point> virus, int time) {
        Queue<Point> q = new LinkedList<>(virus);

        int cnt = 0;
        while(!q.isEmpty()) {
            if(cnt == time)
                break;
            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                if(now.y == end.y && now.x == end.x) {
                    return map[now.y][now.x];
                }
                for(int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];
                    if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] != 0) continue;
                    map[ny][nx] = map[now.y][now.x];
                    q.add(new Point(ny, nx));
                }
            }
            cnt++;
        }

        return map[end.y][end.x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Point> virus = new ArrayList<>();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)
                    virus.add(new Point(i, j));
            }
        }

        virus.sort((a, b) -> map[a.y][a.x] - map[b.y][b.x]);

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        bw.write(solve(virus, time) + "");
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
