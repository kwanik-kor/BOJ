package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: acmicpc.net/problem/25629
 */
public class sml_25629_oddEvenArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

        int oddMax = N % 2 == 0 ? N / 2 : N / 2 + 1;
        int evenMax = N / 2;

        int oddIdx = 0;
        int evenIdx = 0;

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                evenIdx++;
                if (evenIdx > evenMax) {
                    flag = false;
                    break;
                }
            } else {
                oddIdx++;
                if (oddIdx > oddMax) {
                    flag = false;
                    break;
                }
            }
        }

        bw.write(flag? "1" : "0");

        bw.flush();
        bw.close();
        br.close();
    }
}
