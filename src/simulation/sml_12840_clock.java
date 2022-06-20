package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12840
 */
public class sml_12840_clock {

    static final int DAY = 60 * 60 * 24;
    static final int HOUR = 60 * 60;
    static final int MINUTE = 60;

    static int add(int tot, int second) {
        return (tot + (second % DAY)) % DAY;
    }

    static int subtract(int tot, int second) {
        second %= DAY;
        return tot < second ? tot + DAY - second : tot - second;
    }

    static String timeToString(int time) {
        int hour = time / HOUR;
        time %= HOUR;
        int minute = time / MINUTE;
        return hour + " " + minute + " " + time % MINUTE + "\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken()) * HOUR + Integer.parseInt(st.nextToken()) * MINUTE + Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            switch (flag) {
                case 1:
                    time = add(time, Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    time = subtract(time, Integer.parseInt(st.nextToken()));
                    break;
                default:
                    bw.write(timeToString(time));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
