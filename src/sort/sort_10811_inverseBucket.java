package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10811
 */
public class sort_10811_inverseBucket {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            inverse(arr, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i != N - 1) System.out.print(" ");
        }

        br.close();
    }

    static void inverse(int[] arr, int start, int end) {
        while (end > start) {
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;

            end--;
            start++;
        }
    }
}
