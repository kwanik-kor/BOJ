package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2139
 */
public class sml_02139_IKnowYourDays {

    static final int[] MONTH_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            if (day == 0 && month == 0 && year == 0) {
                break;
            }

            int cnt = 0;
            for (int i = 1; i < month; i++) {
                if (i == 2) {
                    if (year % 4 == 0) {
                        if (year % 100  == 0 && year % 400 != 0) {
                            cnt += MONTH_DAYS[i];
                        } else {
                            cnt += 29;
                        }
                    } else {
                        cnt += MONTH_DAYS[i];
                    }
                    continue;
                }
                cnt += MONTH_DAYS[i];
            }
            cnt += day;
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
