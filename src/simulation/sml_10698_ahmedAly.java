package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10698
 */
public class sml_10698_ahmedAly {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char seq = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            boolean ans = true;
            if (seq == '+' && a + b != c) ans = false;
            else if (seq == '-' && a - b != c) ans = false;
            bw.write(String.format("Case %d: %s\n", i, ans? "YES" : "NO"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
