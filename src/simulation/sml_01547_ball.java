package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1547
 */
public class sml_01547_ball {

    static StringTokenizer st;
    static int M;
    static boolean[] cups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());

        cups = new boolean[3];
        cups[0] = true;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            switchCup(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        int ans = 0;
        for(int i = 0; i < 3; i++) {
            if(cups[i]) {
                ans = i;
                break;
            }
        }

        bw.write(ans + 1 + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void switchCup(int a, int b) {
        boolean temp = cups[a];
        cups[a] = cups[b];
        cups[b] = temp;
    }
}
