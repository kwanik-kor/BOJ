package simulation;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3190
 */
public class sml_03190_snake {
    static final int APPLE = 1, SNAKE = 2;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static char[] query = new char[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            query[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        Snake snake = new Snake();

        bw.write(snake.moveAndGetTime() + "");
        bw.close();
        br.close();
    }

    static class Snake {
        int dir = 1;
        Deque<Integer> deque = new LinkedList<>();

        public Snake() {
            deque.add(0);
            map[0][0] = SNAKE;
        }

        int moveAndGetTime() {
            int time = 0;

            while (true) {
                time++;

                int ny = deque.peekFirst() / N + dy[dir];
                int nx = deque.peekFirst() % N + dx[dir];

                if (ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] == SNAKE) break;

                if (map[ny][nx] == APPLE) {
                    map[ny][nx] = SNAKE;
                    deque.addFirst(ny * N + nx);
                } else {
                    map[ny][nx] = SNAKE;
                    map[deque.peekLast() / N][deque.peekLast() % N] = 0;
                    deque.pollLast();
                    deque.addFirst(ny * N + nx);
                }

                if (time <= 10000 && (query[time] == 'L' || query[time] == 'D')) rotate(query[time]);
            }

            return time;
        }

        private void rotate(char type) {
            dir = type == 'L'
                    ? (dir + 3) % 4
                    : (dir + 1) % 4;
        }
    }

}
