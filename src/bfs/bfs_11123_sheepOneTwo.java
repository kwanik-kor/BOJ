package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11123
 */
public class bfs_11123_sheepOneTwo {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static void solve(Integer start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        map[start / C][start % C] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            int y = now / C;
            int x = now % C;
            for(int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = 1;
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
            List<Integer> checkList = new ArrayList<>();
            for(int i = 0; i < R; i++) {
                char[] arr = br.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    if(arr[j] == '#') {
                        checkList.add(i * C + j);
                        map[i][j] = -1;
                    }
                }
            }
            int ans = 0;
            for(Integer point : checkList) {
                if(map[point / C][point % C] == -1) {
                    solve(point);
                    ans++;
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
