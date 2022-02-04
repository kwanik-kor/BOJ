package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15921
 * 2. 풀이
 *  - 사실 입력 N이 0이 아니라면 1.00을 0이라면 divide in zero를 출력하면 됨
 */
public class math_15921_marineBoy {

    static double calcExpectedValue(double N, Map<Double, Double> map) {
        return map.keySet().stream().mapToDouble(val -> val * map.get(val) / N).sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double N = Double.parseDouble(br.readLine());
        if(N == 0) {
            bw.write("divide by zero");
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Double, Double> map = new HashMap<>();
            double sum = 0d;
            for(int i = 0; i < N; i++) {
                double no = Double.parseDouble(st.nextToken());
                sum += no;
                if(map.containsKey(no)) {
                    map.put(no, map.get(no) + 1d);
                } else {
                    map.put(no, 1d);
                }
            }

            double e = calcExpectedValue(N, map);
            if(e == 0)
                bw.write("divide by zero");
            else {
                bw.write(String.format("%.2f", sum / N / e));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
