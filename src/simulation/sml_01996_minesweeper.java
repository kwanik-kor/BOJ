package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1996
 */
public class sml_01996_minesweeper {

    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] mine = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == '.') continue;

                mine[i][j] = -1;
                for (int dir = 0; dir < 8; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if (ny < 0 || nx < 0 || N <= ny || N <= nx || mine[ny][nx] == -1) continue;
                    mine[ny][nx] += arr[j] - '0';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mine[i][j] == -1) bw.write("*");
                else if (mine[i][j] >= 10) bw.write("M");
                else bw.write(mine[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
