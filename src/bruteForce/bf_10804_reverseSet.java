package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10804
 */
public class bf_10804_reverseSet {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cards = new int[21];

    public static void main(String[] args) throws IOException {
        new bf_10804_reverseSet().solve();
    }

    private void solve() throws IOException {
        initializeCard();

        int cnt = 10;
        while (cnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            reverse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= 20; i++) {
            System.out.print(cards[i] + " ");
        }
    }

    private void reverse(int a, int b) {
        if (a == b) return;
        int start = a;
        int end = b;

        while (start < end) {
            int tmp = cards[end];
            cards[end] = cards[start];
            cards[start] = tmp;
            start++;
            end--;
        }
    }

    private void initializeCard() {
        for (int i = 1; i <= 20; i++) {
            cards[i] = i;
        }
    }
}
