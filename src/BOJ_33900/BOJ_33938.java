package BOJ_33900;

import java.io.*;
import java.util.*;

public class BOJ_33938 {
    private static final int OFFSET = 10000;

    private static int solve(Set<Integer> coins, int m) {
        final boolean[] visit = new boolean[20001];
        final Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visit[OFFSET] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int now = q.poll();
                if (now == m) return count;

                for (Integer coin : coins) {
                    int next = now + coin;
                    if (next < -OFFSET || next > OFFSET || visit[next + OFFSET]) continue;
                    visit[next + OFFSET] = true;
                    q.add(next);
                }
            }

            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 0) {
            bw.write(m == 0 ? "0" : "-1");
        } else {
            st = new StringTokenizer(br.readLine());
            List<Integer> coins = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                coins.add(Integer.parseInt(st.nextToken()));
            }

            bw.write(solve(new HashSet<>(coins), m) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
