package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25893
 */
public class sml_25893_majestic10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int cnt = (int) Arrays.stream(arr)
                    .filter(num -> num >= 10)
                    .count();
            switch (cnt) {
                case 0:
                    bw.write(String.format("%d %d %d\n%s\n", arr[0], arr[1], arr[2], "zilch"));
                    break;
                case 1:
                    bw.write(String.format("%d %d %d\n%s\n", arr[0], arr[1], arr[2], "double"));
                    break;
                case 2:
                    bw.write(String.format("%d %d %d\n%s\n", arr[0], arr[1], arr[2], "double-double"));
                    break;
                default:
                    bw.write(String.format("%d %d %d\n%s\n", arr[0], arr[1], arr[2], "triple-double"));
                    break;
            }
            if (N > 0) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
