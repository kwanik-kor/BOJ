package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5074
 */
public class sml_05074_whenDoWeFinish {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Time a = new Time(st.nextToken());
            Time b = new Time(st.nextToken());
            if (a.getHour() == 0 && a.getMinute() == 0 && b.getHour() == 0 && b.getMinute() == 0) {
                break;
            }
            bw.write(a.add(b));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Time {
        int hour;
        int minute;
        int cash;

        public Time(String time) {
            String[] args = time.split(":");
            hour = Integer.parseInt(args[0]);
            minute = Integer.parseInt(args[1]);
            cash = 0;
        }

        public int getDateOnMinute() {
            return hour * 60 + minute;
        }

        public String add(Time t) {
            int tot = getDateOnMinute() + t.getDateOnMinute();
            int n = tot / 60 / 24;
            int h = tot / 60 % 24;
            int m = tot % 60;
            return n > 0
                    ? String.format("%02d:%02d +%d\n", h, m, n)
                    : String.format("%02d:%02d\n", h, m);
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }
    }
}
