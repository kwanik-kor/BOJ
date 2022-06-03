package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/7873
 * 2. 풀이
 *  - 진행 방식은 일반적인 BFS와 동일하나, 각 방향으로 나아갈 수 있는 조건이 추가되었다
 *  - 해당 조건은 비트마스킹을 통해서 진행 가능한 방향인지 체크한다.
 */
public class bfs_07873_decision {

    static int R, C;
    static int[] dirFlag = {1, 2, 4, 8};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] area;

    static void setArea(int idx, int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        area[y][x] = idx;
        q.add(y * C + x);

        while (!q.isEmpty()) {
            int now = q.poll();
            int nowY = now / C;
            int nowX = now % C;
            for (int dir = 0; dir < 4; dir++) {
                if ((map[nowY][nowX] & dirFlag[dir]) != dirFlag[dir]) continue;

                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];
                if (ny < 0 || nx < 0 || R <= ny || C <= nx || area[ny][nx] != 0 || (map[ny][nx] & dirFlag[(dir + 2) % 4]) != dirFlag[(dir + 2) % 4]) continue;
                area[ny][nx] = idx;
                q.add(ny * C + nx);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            area = new int[R][C];

            for (int i = 0; i < R; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    map[i][j] = availableDirection(line[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0 && area[i][j] == 0) {
                        setArea(++cnt, i, j);
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int availableDirection(char c) {
        switch(c) {
            case 'B': return 12;
            case 'C': return 9;
            case 'D': return 3;
            case 'E': return 6;
            case 'F': return 15;
            default: return 0;
        }
    }

}
