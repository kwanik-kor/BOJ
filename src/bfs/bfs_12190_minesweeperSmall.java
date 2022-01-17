package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12190
 * 2. 풀이
 *  - 지뢰찾기를 최소한의 클릭 수로 성공하는 방법을 찾는 문제다.
 *  - 최소한의 클릭 수가 되기 위해서는, 주변(8 directions)에 지뢰가 없는 '0'이 나타나는 영역을
 *    선택하고, 남는 영역을 모두 클릭해야 한다.
 *    단, '0'인 영역을 선택할 때는 주변에 0이 아닌 영역까지 확장되기 때문에 이를 BFS로 처리한다.
 *  - 위 방법을 사용하기 위해서는 지뢰찾기 판에 숫자를 미리 세팅을 해야 하는데,
 *    처음 인풋을 받을 때부터 지뢰 인근의 영역에 숫자를 증가시켜 둔다.
 */
public class bfs_12190_minesweeperSmall {

    static int N;
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};

    static char[][] map;
    static int[][] sweep;
    static boolean[][] visit;

    static int visitZeroArea(int y, int x) {
        int visitCnt = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visit[y][x] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(!inBound(ny, nx) || visit[ny][nx]) continue;

                visitCnt++;
                visit[ny][nx] = true;

                if(sweep[ny][nx] == 0)
                    q.add(new Node(ny, nx));
            }
        }

        return visitCnt;
    }

    static void setHints(int y, int x) {
        sweep[y][x] = -1;

        for(int dir = 0; dir < 8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(!inBound(ny, nx) || map[ny][nx] == '*') continue;
            sweep[ny][nx]++;
        }
    }

    static boolean inBound(int y, int x) {
        return 0 <= y && 0 <= x && y < N && x < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            // init
            map = new char[N][N];
            sweep = new int[N][N];
            visit = new boolean[N][N];

            int mineCount = 0;

            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '*') {
                        setHints(i, j);
                        mineCount++;
                    }
                }
            }

            int totCnt = N * N - mineCount;
            int clickCnt = 0;
            int findCnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(sweep[i][j] == 0 && !visit[i][j]) {
                        clickCnt++;
                        findCnt += visitZeroArea(i, j);
                    }
                }
            }

            int ans = clickCnt + (totCnt - findCnt);
            bw.write(String.format("Case #%d: %d\n", t, ans));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
