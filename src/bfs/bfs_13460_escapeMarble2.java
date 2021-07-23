package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13460
 * 2. 풀이
 *  - 구슬 탈출 1과 동일한 방법으로 풀이가 가능하며, 완료 조건을 달성했을때 소요된 시간을 리턴하면 됨
 *  - 여기는 10초 제한 없는줄알고 조건 뺐다가 한 번 더 틀림;
 */
public class bfs_13460_escapeMarble2 {

    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;

    static Marble start = new Marble();

    static int solve() {
        int time = 0;

        boolean[][][][] visit = new boolean[N][M][N][M];
        visit[start.ry][start.rx][start.by][start.bx] = true;

        Queue<Marble> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            if(time == 10)
                return -1;

            int size = q.size();
            while(size-- > 0) {
                Marble now = q.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nry = now.ry;
                    int nrx = now.rx;
                    int nby = now.by;
                    int nbx = now.bx;

                    boolean rOut = false;
                    boolean bOut = false;

                    while(true) {
                        nry += dy[dir];
                        nrx += dx[dir];
                        if(map[nry][nrx] == '#') {
                            nry -= dy[dir];
                            nrx -= dx[dir];
                            break;
                        }
                        if(map[nry][nrx] == 'O') {
                            rOut = true;
                            break;
                        }
                    }

                    while(true) {
                        nby += dy[dir];
                        nbx += dx[dir];
                        if(map[nby][nbx] == '#') {
                            nby -= dy[dir];
                            nbx -= dx[dir];
                            break;
                        }
                        if(map[nby][nbx] == 'O') {
                            bOut = true;
                            break;
                        }
                    }

                    if(bOut) continue;
                    if(rOut) return time + 1;

                    if(nry == nby && nrx == nbx) {
                        boolean flag = redFirst(now, dir);
                        switch(dir) {
                            case 0: // 위
                                if(flag) nby++;
                                else nry++;
                                break;
                            case 1: // 아래
                                if(flag) nby--;
                                else nry--;
                                break;
                            case 2: // 왼
                                if(flag) nbx++;
                                else nrx++;
                                break;
                            default: // 오
                                if(flag) nbx--;
                                else nrx--;
                        }
                    }
                    if(visit[nry][nrx][nby][nbx]) continue;
                    visit[nry][nrx][nby][nbx] = true;
                    q.add(new Marble(nry, nrx, nby, nbx));
                }
            }

            time++;
        }

        return -1;
    }

    static boolean redFirst(Marble m, int dir) {
        // 위아래
        switch(dir) {
            case 0: // 위
                return m.ry < m.by;
            case 1: // 아래
                return m.ry > m.by;
            case 2: // 왼쪽
                return m.rx < m.bx;
            default: // 오른쪽
                return m.rx > m.bx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'R') {
                    start.setRy(i);
                    start.setRx(j);
                    map[i][j] = '.';
                } else if(map[i][j] == 'B') {
                    start.setBy(i);
                    start.setBx(j);
                    map[i][j] = '.';
                }
            }
        }
        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Marble {
        int ry;
        int rx;
        int by;
        int bx;

        public Marble() {}
        public Marble(int ry, int rx, int by, int bx) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
        }

        public void setRy(int ry) {
            this.ry = ry;
        }

        public void setRx(int rx) {
            this.rx = rx;
        }

        public void setBy(int by) {
            this.by = by;
        }

        public void setBx(int bx) {
            this.bx = bx;
        }
    }
}
