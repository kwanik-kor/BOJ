package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2712
 */
public class sml_02712_americaStyle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double mount = Double.parseDouble(st.nextToken());
            Unit unit = Unit.of(st.nextToken());
            bw.write(unit.convert(mount) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    enum Unit {
        KG("kg"),
        L("l"),
        LB("lb"),
        G("g");

        private String unitName;

        Unit(String unitName) {
            this.unitName = unitName;
        }

        public static Unit of(String name) {
            return Arrays.asList(Unit.values()).stream()
                    .filter(a -> name.equals(a.unitName))
                    .findFirst()
                    .get();
        }

        public String convert(Double value) {
            if (this == KG || this == LB) {
                return convertWeight(value);
            }
            return convertVolume(value);
        }

        private String convertWeight(Double value) {
            return this == KG
                    ? String.format("%.4f lb", value * 2.2046d)
                    : String.format("%.4f kg", value * 0.4536d);
        }

        private String convertVolume(Double value) {
            return this == L
                    ? String.format("%.4f g", value * 0.2642d)
                    : String.format("%.4f l", value * 3.7854d);
        }

    }
}
