package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class greedy_01213_makePalindrome {
    static final String UNAVAILABLE = "I'm Sorry Hansoo";
    static final int ALPHABET_LENGTH = 26;

    static int len;
    static int count[] = new int[ALPHABET_LENGTH];

    static String solve(char[] arr, int idx) {
        while (true) {
            if (idx == len / 2) {
                if (len % 2 == 0) {
                    break;
                }

                for (int i = 0; i < ALPHABET_LENGTH; i++) {
                    if (count[i] == 1) {
                        arr[idx] = (char)(i + 'A');
                        break;
                    }
                }
                break;
            }

            char c = 0;
            for (int i = 0; i < ALPHABET_LENGTH; i++) {
                if (count[i] <= 1) {
                    continue;
                } else {
                    c = (char) (i + 'A');
                    count[i] -= 2;
                    break;
                }
            }
            arr[idx] = arr[len - idx - 1] = c;
            idx++;
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        len = line.length();
        for(int i = 0; i < len; i++) {
            count[line.charAt(i) - 'A']++;
        }

        //우선 짝수개인지 확인
        int oddCnt = 0;
        for(int i = 0; i < ALPHABET_LENGTH; i++) {
            if (count[i] % 2 != 0) {
                oddCnt++;
            }
        }

        if (oddCnt > 1) {
            bw.write(UNAVAILABLE);
        } else {
            char arr[] = new char[len];
            bw.write(solve(arr, 0));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
