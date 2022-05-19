package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5751
 */
public class sml_05751_headOrTail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int mary = 0, john = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                if (Integer.parseInt(st.nextToken()) == 0) mary++;
                else john++;
            }
            bw.write(String.format("Mary won %d times and John won %d times\n", mary, john));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
