package algospot.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] friends;

    void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friends = new boolean[n][n];
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = friends[b][a] = true;
        }

        System.out.println(makePair(n, new boolean[n]));
    }

    int makePair(int n, boolean[] paired) {
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (!paired[i]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) return 1;

        int ret = 0;
        for (int i = idx + 1; i < n; i++) {
            if (paired[i] || !friends[i][idx]) continue;

            paired[i] = paired[idx] = true;
            ret += makePair(n, paired);
            paired[i] = paired[idx] = false;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine().trim());

        Picnic picnic = new Picnic();
        while (T-- > 0) {
            picnic.solve();
        }
    }

}
