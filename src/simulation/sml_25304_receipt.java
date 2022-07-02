package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25304
 */
public class sml_25304_receipt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long tot = 0L;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tot += Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
        }
        bw.write(X == tot ? "Yes" : "No");

        bw.flush();
        bw.close();
        br.close();
    }
}
