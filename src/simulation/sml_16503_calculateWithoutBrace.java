package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * 1. 문제링크: https://www.acmicpc.net/problem/16503
 */
public class sml_16503_calculateWithoutBrace {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int resultA = calculate(line, true);
        int resultB = calculate(line, false);
        bw.write(String.format("%d\n%d", Math.min(resultA, resultB), Math.max(resultA, resultB)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int calculate(String[] line, boolean asc) {
        Calculator first = Calculator.of(line[1]);
        Calculator second = Calculator.of(line[3]);
        return asc
                ? calculate(second, calculate(first, Integer.parseInt(line[0]), Integer.parseInt(line[2])), Integer.parseInt(line[4]))
                : calculate(first, Integer.parseInt(line[0]),  calculate(second, Integer.parseInt(line[2]), Integer.parseInt(line[4])));
    }

    static int calculate(Calculator c, Integer a, Integer b) {
        return c.getCalculate().apply(a, b);
    }

    private enum Calculator {
        ADD("+", (a, b) -> a + b),
        SUBTRACT("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> calculate;

        Calculator(String symbol, BiFunction<Integer, Integer, Integer> calculate) {
            this.symbol = symbol;
            this.calculate = calculate;
        }

        public static Calculator of(String symbol) {
            return Arrays.stream(Calculator.values())
                    .filter(c -> c.getSymbol().equals(symbol))
                    .findFirst()
                    .orElse(null);
        }

        public String getSymbol() {
            return symbol;
        }

        public BiFunction<Integer, Integer, Integer> getCalculate() {
            return calculate;
        }
    }
}
