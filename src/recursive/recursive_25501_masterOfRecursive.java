package recursive;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25501
 */
public class recursive_25501_masterOfRecursive {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int left = 0;
            int right = arr.length - 1;

            int cnt = 1;
            boolean flag = true;
            while (left < right) {
                if (arr[left] != arr[right]) {
                    flag = false;
                    break;
                }
                left++;
                right--;
                cnt++;
            }

            bw.write(String.format("%d %d\n", flag ? 1 : 0, cnt));
        }

        bw.close();
        br.close();
    }

}
