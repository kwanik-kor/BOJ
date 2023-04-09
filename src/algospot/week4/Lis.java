package algospot.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lis {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr = new int[501];
    static int[] memo = new int[501];

    public static void main(String[] args) throws Exception {
        Lis main = new Lis();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            main.solve();
        }
    }

    private void solve() throws Exception {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = 0;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int targetIdx = binarySearch(arr[i], 0, max, max + 1);

            if (targetIdx == -1) {
                memo[max++] = arr[i];
            } else {
                memo[targetIdx] = arr[i];
            }
        }

        System.out.println(max);
    }

    private int binarySearch(int target, int start, int end, int size) {
        int ret = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= memo[mid]) {
                ret = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start == size) {
            return -1;
        }
        return ret;
    }

}
