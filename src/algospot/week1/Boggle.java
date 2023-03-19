package algospot.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boggle {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static final int SIZE = 5;
    static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        Boggle boggle = new Boggle();
        int caseCnt = Integer.parseInt(br.readLine());
        while (caseCnt-- > 0) {
            boggle.solve();
        }
        System.out.print(sb.toString());
    }

    void solve() throws Exception {
        char[][] map = initializeMap();

        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            String word = br.readLine();
            boolean result = checkCanFind(map, word);
            sb.append(String.format("%s %s\n", word, result ? "YES" : "NO"));
        }
    }

    private char[][] initializeMap() throws IOException {
        char[][] map = new char[SIZE][SIZE];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        return map;
    }

    private boolean checkCanFind(char[][] map, String word) {
        int len = word.length();
        boolean[][][] visit = new boolean[SIZE][SIZE][len];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == word.charAt(0)) {
                    q.add(i * SIZE + j);
                    visit[i][j][0] = true;
                }
            }
        }

        int flag = 1;
        while (!q.isEmpty()) {
            if (flag == len) return true;

            int size = q.size();
            while (size-- > 0) {
                int y = q.peek() / SIZE;
                int x = q.peek() % SIZE;
                q.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (isOutOfRange(ny, nx) || map[ny][nx] != word.charAt(flag) || visit[ny][nx][flag]) continue;

                    q.add(ny * SIZE + nx);
                    visit[ny][nx][flag] = true;
                }
            }

            flag++;
        }


        return false;
    }

    private boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || SIZE <= y || SIZE <= x;
    }

}