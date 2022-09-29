package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15818
 */
public class sml_15818_moduler {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long result = 1L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            result = ((result % M) * (Long.parseLong(st.nextToken()) % M)) % M;
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
