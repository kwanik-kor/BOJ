package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17263
 */
public class sml_17263_sortMaster {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Integer.parseInt(st.nextToken()));
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
