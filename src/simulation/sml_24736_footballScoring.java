package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24736
 */
public class sml_24736_footballScoring {

    static int[] scores = {6, 3, 2, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tot = IntStream.range(0, 5).map(idx -> Integer.parseInt(st.nextToken()) * scores[idx]).sum();
            bw.write(tot + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
