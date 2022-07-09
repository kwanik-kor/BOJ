package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/21603
 */
public class sml_21603_K2KGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) % 10;
        int K2 = (K * 2) % 10;
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int mod = i % 10;
            if (mod != K && mod != K2) {
                li.add(i);
            }
        }

        bw.write(li.size() + "");
        if (li.size() != 0) {
            bw.write("\n");
            for (Integer i : li) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
