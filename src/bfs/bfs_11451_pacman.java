package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11451
 * 2. 풀이
 *  - 두 팩맨의 움직임을 구현만 잘해낸다면 크게 어려울 것이 없다.
 *  - 사차원 배열로 두 팩맨의 움직임을 visit로 기록해주자.
 */
public class bfs_11451_pacman {

    static final String DIRECTION = "NESW";

    static int M, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][][][] visit = new int[51][51][51][51];
    static char[][] map = new char[51][51];

    static Pacman pacman;

    static Pacman solve() {
        initVisit();

        Queue<Pacman> q = new LinkedList<>();
        q.add(pacman);
        visit[pacman.y1][pacman.x1][pacman.y2][pacman.x2] = 0;

        while(!q.isEmpty()) {
            Pacman now = q.poll();
            if(now.y1 == now.y2 && now.x1 == now.x2) {
                return now;
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny1 = getNextNode(now.y1 + dy[dir], M);
                int nx1 = getNextNode(now.x1 + dx[dir], N);
                if(map[ny1][nx1] == 'X') {
                    ny1 = now.y1;
                    nx1 = now.x1;
                }
                int ny2 = getNextNode(now.y2 + dy[dir], M);
                int nx2 = getNextNode(now.x2 + dx[dir], N);
                if(map[ny2][nx2] == 'X') {
                    ny2 = now.y2;
                    nx2 = now.x2;
                }

                if(map[ny1][nx1] == 'G' || map[ny2][nx2] == 'G' || visit[ny1][nx1][ny2][nx2] != -1) continue;

                visit[ny1][nx1][ny2][nx2] = visit[now.y1][now.x1][now.y2][now.x2] + 1;
                q.add(new Pacman(ny1, nx1, ny2, nx2, now.path + DIRECTION.charAt(dir)));
            }
        }

        return null;
    }

    static int getNextNode(int pos, int limit) {
        // 범위를 벗어난 경우
        if(pos < 0) {
            return limit - 1;
        } else if(limit <= pos) {
            return 0;
        }
        return pos;
    }

    static void initVisit() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    for(int l = 0; l < N; l++) {
                        visit[i][j][k][l] = -1;
                    }
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
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int y1 = -1, x1 = -1, y2 = -1, x2= -1;
            for(int i = 0; i < M; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'P') {
                        if(y1 == -1) {
                            y1 = i;
                            x1 = j;
                        } else {
                            y2 = i;
                            x2 = j;
                        }
                        map[i][j] = '.';
                    }
                }
            }

            pacman = new Pacman(y1, x1, y2, x2, "");

            Pacman ans = solve();
            if(ans == null) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(visit[ans.y1][ans.x1][ans.y2][ans.x1] + " " + ans.path + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Pacman {
        int y1;
        int x1;
        int y2;
        int x2;
        String path;
        public Pacman(int y1, int x1, int y2, int x2, String path) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
            this.path = path;
        }
    }
}

