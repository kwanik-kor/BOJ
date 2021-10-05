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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16432
 * 2. 풀이
 *  - DFS를 이용해서 가장 빠르게 호랭이한테 떡을 먹일 수 있는 경로를 찾아내면 됨.
 *  - 단, 특정 일자에 특정 떡을 준 case에 대한 방문처리를 하지 않아 시간초과가 났음
 *    > 이에, 방문처리를 추가해서 통과함!
 */
public class dfs_15900_escapeTree {

    static int N;
    static boolean solved = false;
    static int[] dduck;
    static int[] ans;
    static boolean[][] visit;
    static List<Integer>[] days;

    static void solve(int day) {
       if(solved) return;

       if(day == N + 1) {
           for(int i = 1; i <= N; i++) {
               ans[i] = dduck[i];
           }
           solved = true;
           return;
       }

       for(Integer d : days[day]) {
           if(d == dduck[day - 1] || visit[day][d]) continue;
           visit[day][d] = true;
           dduck[day] = d;
           solve(day + 1);
           dduck[day] = 0;
           if(solved) return;
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        days = new List[N + 1];
        dduck = new int[N + 1];
        ans = new int[N + 1];
        visit = new boolean[N + 1][10];
        for (int i = 1; i <= N; i++) {
            days[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                days[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        solve(1);

        if (ans[N] == 0) {
            bw.write("-1");
        } else {
            for(int i = 1; i <= N; i++) {
                bw.write(ans[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
