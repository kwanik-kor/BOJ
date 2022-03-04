package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2511
 */
public class sml_02511_cardGame {

    static final char[] win = {'A', 'B'};

    static int[][] card = new int[10][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                card[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = -1;
        int[] point = new int[2];

        for(int i = 0; i < 10; i++) {
            if(card[i][0] < card[i][1]) {
                point[1] += 3;
                winner = 1;
            } else if(card[i][1] < card[i][0]) {
                point[0] += 3;
                winner = 0;
            } else {
                point[0]++;
                point[1]++;
            }
        }

        bw.write(point[0] + " " + point[1] + "\n");
        if (winner == -1) bw.write("D");
        else if (point[0] < point[1]) bw.write(win[1]);
        else if (point[1] < point[0]) bw.write(win[0]);
        else {
            if(winner == 1) bw.write(win[1]);
            else bw.write(win[0]);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
