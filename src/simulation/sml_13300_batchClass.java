package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13300
 */
public class sml_13300_batchClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] classes = new int[7][2];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            classes[grade][gender]++;
        }

        int tot = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (classes[i][j] == 0) continue;
                tot += classes[i][j] / k;
                if (classes[i][j] % k != 0) {
                    tot++;
                }
            }
        }

        bw.write(tot + "");
        bw.close();
        br.close();
    }

}
