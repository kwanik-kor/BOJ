package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5568
 */
public class backtracking_05568_putCard {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[] cards;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        backtracking_05568_putCard main = new backtracking_05568_putCard();
        main.solve();

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        int[] selected = new int[k];
        boolean[] visit = new boolean[n];
        backtracking(0, visit, selected);

        bw.write(set.size() + "");
    }

    private void backtracking(int cnt, boolean[] visit, int[] selected) {
        if (cnt == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(cards[selected[i]]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            selected[cnt] = i;
            backtracking(cnt + 1, visit, selected);
            visit[i] = false;
        }
    }

    private void initialize() throws Exception {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
    }
}
