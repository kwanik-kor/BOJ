package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14656
 */
public class sml_14656_sadist {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i != Integer.parseInt(st.nextToken())) {
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
