package algospot.week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/BRACKETS2
 */
public class Brackets2 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Brackets2 main = new Brackets2();
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            main.solve();
        }
        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean result = true;
        for (int i = 0, n = input.length; i < n; i++) {
            if (Bracket.isOpenBracket(input[i])) {
                stack.push(input[i]);
                continue;
            }

            char open = Bracket.findOpenBracket(input[i]);
            if (stack.isEmpty() || stack.peek() != open) {
                result = false;
                break;
            }
            stack.pop();
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        bw.write(result ? "YES\n" : "NO\n");
    }

    private enum Bracket {
        SMALL('(', ')'),
        MEDIUM('{', '}'),
        LARGE('[', ']')
        ;

        private char open, close;

        Bracket(char open, char close) {
            this.open = open;
            this.close = close;
        }

        private static boolean isOpenBracket(char c) {
            return Arrays.stream(Bracket.values())
                    .anyMatch(bracket -> bracket.getOpen() == c);
        }

        private static char findOpenBracket(char c) {
            return Arrays.stream(Bracket.values())
                    .filter(bracket -> bracket.getClose() == c)
                    .map(Bracket::getOpen)
                    .findFirst()
                    .orElseGet(null);
        }

        public char getOpen() {
            return open;
        }

        public char getClose() {
            return close;
        }
    }

}
