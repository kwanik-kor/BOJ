package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3028
 */
public class sml_03028_village {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        if (line == null || line.equals("")) {
            bw.write("1");
        } else {
            char[] order = line.toCharArray();
            boolean[] result = new boolean[3];
            result[0] = true;
            for (int i = 0; i < order.length; i++) {
                if (order[i] == 'A') {
                    result = swap(result, 0, 1);
                } else if (order[i] == 'B') {
                    result = swap(result, 1, 2);
                } else {
                    result = swap(result, 0, 2);
                }
            }
            bw.write(result[0] ? "1" : (result[1] ? "2" : "3"));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean[] swap(boolean[] arr, int a, int b) {
        boolean tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }
}
