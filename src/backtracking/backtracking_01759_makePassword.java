package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1759
 */
public class backtracking_01759_makePassword {
    static int L, C;
    static char[] arr;

    static void backtracking(int start, int len, int vowel, int consonant, String str) {
        if (len == L && vowel >= 1 && consonant >= 2) {
            System.out.println(str);
            return;
        }

        for (int i = start; i < C; i++) {
            if (isVowel(arr[i])) {
                backtracking(i + 1, len + 1, vowel + 1, consonant, str + arr[i]);
            } else {
                backtracking(i + 1, len + 1, vowel, consonant + 1, str + arr[i]);
            }
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String[] line = br.readLine().split(" ");
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = line[i].charAt(0);
        }
        Arrays.sort(arr);

        backtracking(0, 0, 0, 0, "");

        br.close();
    }
}
