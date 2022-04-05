package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4493
 */
public class sml_04493_rockScissorPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int game = Integer.parseInt(br.readLine());
            int[] player = new int[2];

            for(int i = 0; i < game; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);
                if (a == b) continue;
                player[getWinner(a, b)]++;
            }
            bw.write(player[0] == player[1] ? "TIE\n" : (player[0] < player[1] ? "Player 2\n" : "Player 1\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int getWinner(char a, char b) {
        switch(a) {
            case 'R':
                if(b == 'S') return 0;
                else return 1;
            case 'S':
                if(b == 'P') return 0;
                else return 1;
            default:
                if(b == 'R') return 0;
                else return 1;
        }
    }
}
