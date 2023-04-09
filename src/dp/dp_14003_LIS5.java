package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14003
 */
public class dp_14003_LIS5 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr, memo, memoIdx;

    public static void main(String[] args) throws IOException {
        new dp_14003_LIS5().solve();
    }

    private void solve() throws IOException {
        initialize();

        int size = 0;
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(arr[i], 0, size, size + 1);
            if (idx == -1) {
                memoIdx[i] = size;
                memo[size++] = arr[i];
            } else {
                memo[idx] = arr[i];
                memoIdx[i] = idx;
            }
        }

        int[] actualLis = createActualLisArray(size);

        System.out.println(createAnswer(actualLis, size));
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

    private int[] createActualLisArray(int maxLength) {
        int[] resultArr = new int[N];
        int tempMemoIdx = maxLength;
        int tempIdx = N;
        while (tempMemoIdx-- > 0) {
            while (--tempIdx >= 0) {
                if (memoIdx[tempIdx] == tempMemoIdx) {
                    resultArr[tempMemoIdx] = arr[tempIdx];
                    break;
                }
            }
        }
        return resultArr;
    }

    private String createAnswer(int[] resultArr, int size) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < size; i++) {
            sj.add(String.valueOf(resultArr[i]));
        }
        return String.format("%d\n%s", size, sj.toString());
    }

    private void initialize() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];
        memoIdx = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = Integer.MIN_VALUE;
            memoIdx[i] = -1;
        }
    }
}
