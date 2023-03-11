package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4459
 */
public class sml_04459_alwaysFollowTheRulesInZombieland {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            int ruleNo = Integer.parseInt(br.readLine());
            try {
                bw.write(String.format("Rule %d: %s\n", ruleNo, arr[ruleNo - 1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                bw.write(String.format("Rule %d: No such rule\n", ruleNo));
            }
        }
        bw.close();
        br.close();
    }
}
