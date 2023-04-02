package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4141
 */
public class sml_04141_numbersrebmun {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] word = lineToNumberArr(br.readLine());
            int start = 0;
            int end = word.length - 1;

            boolean flag = true;
            while (start <= end) {
                if (word[start] != word[end]) {
                    flag = false;
                    break;
                }
                start++;
                end--;
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    static char[] lineToNumberArr(String line) {
        char[] arr = line.toUpperCase().toCharArray();
        for (int i = 0, n = arr.length; i < n; i++) {
            if (arr[i] <= 'C') {
                arr[i] = '2';
            } else if (arr[i] <= 'F') {
                arr[i] = '3';
            } else if (arr[i] <= 'I') {
                arr[i] = '4';
            } else if (arr[i] <= 'L') {
                arr[i] = '5';
            } else if (arr[i] <= 'O') {
                arr[i] = '6';
            } else if (arr[i] <= 'S') {
                arr[i] = '7';
            } else if (arr[i] <= 'V') {
                arr[i] = '8';
            } else {
                arr[i] = '9';
            }
        }
        return arr;
    }
}
