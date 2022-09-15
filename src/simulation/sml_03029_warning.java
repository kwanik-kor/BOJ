package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3029
 */
public class sml_03029_warning {

    static final int[] SECONDS = {60 * 60, 60, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int now = toSeconds(br.readLine());
        int time = toSeconds(br.readLine());

        if (time <= now) {
            time += 60 * 60 * 24;
        }

        int wait = time - now;
        bw.write(secondsToTimeString(wait));
        bw.flush();
        bw.close();
        br.close();
    }

    static String secondsToTimeString(int seconds) {
        int hour = seconds / SECONDS[0];
        seconds %= SECONDS[0];
        int minute = seconds / SECONDS[1];
        return String.format("%02d:%02d:%02d", hour, minute, seconds % SECONDS[1]);
    }

    static int toSeconds(String line) {
        int[] time = stringToTimeArray(line);
        return IntStream.range(0, 3)
                .map(idx -> time[idx] * SECONDS[idx])
                .sum();
    }

    static int[] stringToTimeArray(String line) {
        return Arrays.stream(line.split(":"))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
