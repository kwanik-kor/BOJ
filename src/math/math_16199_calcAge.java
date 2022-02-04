package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16199
 */
public class math_16199_calcAge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Birth birthday = new Birth(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Birth ref = new Birth(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(String.format("%d\n%d\n%d", birthday.calcManAge(ref), birthday.calcSeAge(ref), birthday.calcYearAge(ref)));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Birth {
        int year;
        int month;
        int day;

        public Birth(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int calcManAge(Birth ref) {
            int age = ref.year - this.year;
            if(ref.month < this.month) {
                age--;
            }
            if(ref.month == this.month && ref.day < this.day) {
                age--;
            }
            return age;
        }

        public int calcSeAge(Birth ref) {
            return calcYearAge(ref) + 1;
        }

        public int calcYearAge(Birth ref) {
            return ref.year - this.year;
        }
    }
}
