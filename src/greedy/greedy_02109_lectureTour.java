package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2109
 */
public class greedy_02109_lectureTour {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        boolean[] days = new boolean[10001];
        int tot = 0;
        while (!pq.isEmpty()) {
            Lecture lec = pq.poll();
            for (int day = lec.day; day >= 1; day--) {
                if (days[day]) continue;

                days[day] = true;
                tot += lec.pay;
                break;
            }
        }

        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Lecture implements Comparable<Lecture> {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture a) {
            if (a.pay == this.pay) {
                return a.day - this.day;
            }
            return a.pay - this.pay;
        }
    }
}
