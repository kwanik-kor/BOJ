package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4714
 */
public class sml_04714_lunacy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            float n = Float.parseFloat(br.readLine());
            if (n == -1f) {
                break;
            }
            bw.write(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", n, n * 0.167));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
