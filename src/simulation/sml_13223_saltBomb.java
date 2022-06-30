package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13223
 */
public class sml_13223_saltBomb {

    static final Integer DAY = 60 * 60 * 24;
    static final Integer HOUR = 60 * 60;
    static final Integer MINUTE = 60;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int now = timeStringToTotal(br.readLine());
        int salt = timeStringToTotal(br.readLine());
        if (salt < now) {
            salt += DAY;
        }

        int tot = salt - now;
        if (tot == 0) bw.write("24:00:00");
        else bw.write(String.format("%02d:%02d:%02d", tot / HOUR, tot % HOUR / MINUTE, tot % MINUTE));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int timeStringToTotal(String line) {
        Integer[] arr = Arrays.stream(line.split(":"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return arr[0] * HOUR + arr[1] * MINUTE + arr[2];
    }
}
