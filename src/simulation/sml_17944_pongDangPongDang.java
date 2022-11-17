package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17944
 */
public class sml_17944_pongDangPongDang {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken()) - 1;

        int flag = 4 * N - 2;
        int mod = T % flag;
        if (mod <= 2 * N - 1) {
            bw.write(mod + 1 + "");
        } else {
            bw.write(flag - mod + 1 + "");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
