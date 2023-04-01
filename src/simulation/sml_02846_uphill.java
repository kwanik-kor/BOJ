package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2846
 */
public class sml_02846_uphill {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = -1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                if (start == -1) {
                    start = arr[i - 1];
                }
                max = Math.max(max, arr[i] - start);
            } else {
                start = -1;
            }
        }

        System.out.println(max);
    }

}
