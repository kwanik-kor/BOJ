package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26731
 */
public class sml_26731_zagubionaLitera {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        boolean flag = false;
        for (int i = 0, n = arr.length; i < n; i++) {
            if(arr[i] != i + 'A') {
                bw.write((char) (i + 'A') + "");
                flag = true;
                break;
            }
        }

        if (!flag) {
            bw.write('Z');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
