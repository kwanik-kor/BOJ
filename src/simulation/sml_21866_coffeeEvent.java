package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/21866
 */
public class sml_21866_coffeeEvent {

    static int[] hacker = {100, 100, 200, 200, 300, 300, 400, 400, 500};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        boolean isHacker = false;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > hacker[i]) {
                isHacker = true;
                break;
            }
            sum += n;
        }

        bw.write(isHacker? "hacker" : (sum >= 100 ? "draw" : "none"));

        bw.flush();
        bw.close();
        br.close();
    }
}
