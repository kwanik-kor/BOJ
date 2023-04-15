package algospot.week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/LUNCHBOX
 * 2. 풀이
 *  - 먹는데 오래 걸리는걸 먼저 돌려놓으면 먹는 동안 다른걸 돌리고 먹을 수 있음
 */
public class LunchBox {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Lunch[] boxes = new Lunch[10001];

    public static void main(String[] args) throws Exception {
        LunchBox main = new LunchBox();

        int cases = Integer.parseInt(br.readLine());
        while (cases-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        int ans = 0;
        int cookTime = 0;
        for (int i = 0; i < n; i++) {
            cookTime += boxes[i].getMicrowaveDuration();
            ans = Math.max(ans, cookTime + boxes[i].getEatDuration());
        }

        bw.write(String.format("%d\n", ans));
    }

    private void initialize() throws Exception {
        n = Integer.parseInt(br.readLine());

        StringTokenizer microwave = new StringTokenizer(br.readLine());
        StringTokenizer eat = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            boxes[i] = new Lunch(Integer.parseInt(microwave.nextToken()), Integer.parseInt(eat.nextToken()));
        }
        Arrays.sort(boxes, 0, n);
    }

    private static class Lunch implements Comparable<Lunch> {
        private int microwaveDuration, eatDuration;

        public Lunch(int microwaveDuration, int eatDuration) {
            this.microwaveDuration = microwaveDuration;
            this.eatDuration = eatDuration;
        }

        @Override
        public int compareTo(Lunch o) {
            if (this.eatDuration == o.getEatDuration()) {
                return this.microwaveDuration - o.getMicrowaveDuration();
            }
            return o.getEatDuration() - this.eatDuration;
        }

        public int getMicrowaveDuration() {
            return microwaveDuration;
        }

        public int getEatDuration() {
            return eatDuration;
        }
    }
}
