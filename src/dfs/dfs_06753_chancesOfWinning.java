package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6753
 * 2. 풀이
 *  - Combination(조합) 연산과 유사하게 재귀로 경우의 수를 만들어 응원하는 팀(T)가 최종적으로 우승할 수 있는 경우의 수를 계산한다.
 */
public class dfs_06753_chancesOfWinning {

    static int T, G, ans = 0;
    static boolean[][] done;
    static int[] point;
    static int[][] gamePoint = {{3, 0}, {1, 1}, {0, 3}};
    static List<Game> games = new ArrayList<>();

    static void solve(int idx, int cnt) {
        if(cnt == games.size()) {
            if(didWin()) ans++;
            return;
        }

        for(int i = idx; i < games.size(); i++) {
            for(int j = 0; j < 3; j++) {
                Game g = games.get(i);
                point[g.a] += gamePoint[j][0];
                point[g.b] += gamePoint[j][1];
                solve(i + 1, cnt + 1);
                point[g.a] -= gamePoint[j][0];
                point[g.b] -= gamePoint[j][1];
            }
        }
    }

    static boolean didWin() {
        int maxIdx = -1;
        int maxPoint = -1;
        int maxCnt = 0;
        for(int i = 1; i <= 4; i++) {
            if(maxPoint < point[i]) {
                maxCnt = 1;
                maxPoint = point[i];
                maxIdx = i;
            } else if(maxPoint == point[i]) {
                maxCnt++;
            }
        }
        return maxIdx == T && maxCnt == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        G = Integer.parseInt(br.readLine());
        point = new int[5];
        done = new boolean[5][5];
        for(int i = 0; i < G; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int aScore = Integer.parseInt(st.nextToken());
            int bScore = Integer.parseInt(st.nextToken());

            done[a][b] = done[b][a] = true;

            if (aScore > bScore) {
                point[a] += 3;
            } else if(aScore == bScore) {
                point[a]++;
                point[b]++;
            } else {
                point[b] += 3;
            }
        }

        for(int i = 1; i <= 4; i++) {
            for(int j = i + 1; j <= 4; j++) {
                if(!done[i][j])
                    games.add(new Game(i, j));
            }
        }

        solve(0, 0);

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Game {
        int a, b;
        public Game(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
