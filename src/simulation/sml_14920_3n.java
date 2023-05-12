package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14920
 */
public class sml_14920_3n {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1;
        int num = Integer.parseInt(br.readLine());
        while (num != 1) {
            num = num % 2 == 0
                    ? (num / 2)
                    : (3 * num + 1);
            n++;
        }
        bw.write(n + "");
        bw.close();
        br.close();
    }
}
