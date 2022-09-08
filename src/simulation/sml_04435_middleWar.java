package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4435
 */
public class sml_04435_middleWar {

    static final int[] GANDALF = {1, 2, 3, 3, 4, 10};
    static final int[] SAURON = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int gandalf = getTotalScore(br.readLine(), GANDALF);
            int sauron = getTotalScore(br.readLine(), SAURON);
            bw.write(String.format("Battle %d: %s\n", i, getResultString(gandalf, sauron)));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int getTotalScore(String line, int[] target) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::valueOf)
                .map(val -> val * target[index.getAndIncrement()])
                .sum();
    }

    static String getResultString(int g, int s) {
        if (g == s) {
            return "No victor on this battle field";
        }
        if (g > s) {
            return "Good triumphs over Evil";
        }
        return "Evil eradicates all trace of Good";
    }
}
