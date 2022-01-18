package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/23085
 * 2. 풀이
 *  - 현재 문제에서 가장 중요한 것은, 몇 번째 동전을 뒤집느냐가 문제가 아니라는 것이다.
 *   - 어차피 동전은 앞/뒤 두 개의 상태만을 가지기 때문에, K 개의 앞 뒤 동전만 BFS를 이용해 경우를 만들어주면 된다.
 */
public class bfs_23085_panchigi {

    static int N, K;

    static int solve(CoinStat init) {
        // 뒷면의 개수
        boolean[] visit = new boolean[N + 1];
        visit[init.t] = true;

        Queue<CoinStat> q = new LinkedList<>();
        q.add(init);
        while(!q.isEmpty()) {
            CoinStat now = q.poll();
            if(now.h == 0)
                return now.cnt;

            for(CoinStat next : now.getNextRound()) {
                if(visit[next.t]) continue;
                visit[next.t] = true;
                q.add(next);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int front = 0;
        int back = 0;
        String status = br.readLine();
        for(int i = 0; i < N; i++) {
            if(status.charAt(i) == 'H')
                front++;
            else
                back++;
        }

        bw.write(solve(new CoinStat(front, back, 0)) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class CoinStat {
        int h, t, cnt;
        public CoinStat(int h, int t, int cnt) {
            this.h = h;
            this.t = t;
            this.cnt = cnt;
        }

        public List<CoinStat> getNextRound() {
            List<CoinStat> ret = new ArrayList<>();

            for(int i = 0; i <= K; i++) {
                if(i <= h && K - i <= t) {
                    ret.add(new CoinStat(h - i + K - i, t - (K - i) + i, cnt + 1));
                }
            }

            return ret;
        }
    }
}
