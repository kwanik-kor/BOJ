package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18691
 */
public class sml_18691_pokemonBuddy {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (c >= e) {
                bw.write("0\n");
            } else {
                bw.write((e - c) * getCandyPerWalk(g) + "\n");
            }
        }
        bw.close();
        br.close();
    }

    private static int getCandyPerWalk(int g) {
        if (g == 1) {
            return 1;
        }
        return g == 2 ? 3 : 5;
    }

}
