package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2765
 */
public class sml_02765_speedOfBicycle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double r = Double.parseDouble(st.nextToken());
            double cycle = Double.parseDouble(st.nextToken());
            double time = Double.parseDouble(st.nextToken());

            if (cycle == 0) {
                break;
            }

            double distance = r / (5280 * 12) * cycle * Math.PI;
            bw.write(String.format("Trip #%d: %.2f %.2f\n", ++testCase, distance, distance / time * 3600));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
