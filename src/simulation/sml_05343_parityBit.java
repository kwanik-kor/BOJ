package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5343
 */
public class sml_05343_parityBit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0, n = arr.length / 8; i < n; i++) {
                int ones = 0;
                for (int j = 0; j < 8; j++) {
                    int arrIdx = i * 8 + j;
                    if (j != 7) {
                        if (arr[arrIdx] == '1')
                            ones++;
                    } else {
                        if ((arr[arrIdx] == '1' && ones % 2 != 1) || (arr[arrIdx] == '0' && ones % 2 != 0))
                            cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
