package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1592
 */
public class sml_01592_youngSikAndFriends {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] cnt = new int[N + 1];
        cnt[1] = 1;
        int tot = 0;
        int idx = 1;

        while (true) {
            if (cnt[idx] == M) break;
            if (cnt[idx] % 2 == 1) {
                idx = idx + L;
            } else {
                idx = idx - L;
            }
            if (idx > N) {
                idx %= N;
            } else if (idx <= 0) {
                idx += N;
            }
            cnt[idx]++;
            tot++;
        }
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
