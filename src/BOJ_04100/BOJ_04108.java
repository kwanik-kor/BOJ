package BOJ_04100;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_04108 {
    private static final char MINE = '*';
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map;
        int[][] openedMap;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0) break;

            map = new char[r][c];
            openedMap = new int[r][c];
            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] != MINE) continue;
                    for (int dir = 0; dir < 8; dir++) {
                        int ny = i + d[dir][0];
                        int nx = j + d[dir][1];
                        if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == MINE) continue;
                        openedMap[ny][nx]++;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == MINE) {
                        bw.write(MINE);
                    } else {
                        bw.write(openedMap[i][j] + "");
                    }
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
