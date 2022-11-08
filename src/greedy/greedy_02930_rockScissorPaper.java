package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2930
 */
public class greedy_02930_rockScissorPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int R = Integer.parseInt(br.readLine());
        char[] sangGeun = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][R];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int score = 0;
        int maxScore = 0;
        for (int i = 0; i < R; i++) {
            char s = sangGeun[i];

            int[] temp = new int[3];
            for (int j = 0; j < N; j++) {
                score += calculateScore(s, arr[j][i]);

                temp[0] += calculateScore('R', arr[j][i]);
                temp[1] += calculateScore('S', arr[j][i]);
                temp[2] += calculateScore('P', arr[j][i]);
            }

            maxScore += Math.max(temp[0], Math.max(temp[1], temp[2]));
        }

        bw.write(score + "\n" + maxScore);
        bw.flush();
        bw.close();
        br.close();
    }

    static int calculateScore(char a, char b) {
        if (a == b) return 1;
        return (getRspIndex(a) + 1) % 3 == getRspIndex(b) ? 2 : 0;
    }

    static int getRspIndex(char c) {
        switch (c) {
            case 'R': return 0;
            case 'S': return 1;
            default : return 2;
        }
    }
}
