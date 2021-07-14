package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15558
 * 2. 풀이
 *  - 두 가지 Main 조건이 있다.
 *    > 1) 세 가지 움직이는 방식
 *    > 2) 시간이 지날 수록 움직일 수 있는 방향이 제한됨
 *  - 움직임은 BFS로 만들면 된다.
 *    > Queue의 사이즈 체크를 통해 시간을 하나씩 올려줬었는데,
 *     움직임이 끝나고 1초마다 첫 줄을 없애 버린다.
 *      >> 이 때문에, Queue 에는 없어진 줄의 좌표가 들어갈 수 있었지만
 *         조건을 빠트려서 두 번 틀려따....
 */
public class bfs_15558_jumpGame {

    static int N, k;
    static int[] dir = {1, -1, 0};
    static int[][] map;

    static boolean solve() {
        // y == 0 > 왼쪽 줄 / y == 1 > 오른쪽 줄
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                
                if(now.x < time) continue; // 체크하지 않아서 틀렸었던 조건

                for(int i = 0; i < 3; i++) {
                    int ny = now.y;
                    int nx = now.x + dir[i];
                    if(i == 2) { // 세 번 째 움직임인 경우
                        ny = now.y == 1? 0 : 1; // 반대 줄로 이동
                        nx += k;
                    }
                    if(N <= nx)
                        return true;

                    if(nx < time || map[ny][nx] != 1) continue;
                    map[ny][nx] = -1;
                    q.add(new Point(ny, nx));
                }
            }

            map[0][time] = -1;
            map[1][time] = -1;
            time++;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[2][N];
        for(int i = 0; i < 2; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = arr[j] - '0';
            }
        }
        bw.write(solve()? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
