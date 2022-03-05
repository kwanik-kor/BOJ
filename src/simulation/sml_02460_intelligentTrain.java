package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2460
 */
public class sml_02460_intelligentTrain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tot = 0;
        int ans = 0;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int on = Integer.parseInt(st.nextToken());
            tot += on - left;
            ans = Math.max(ans, tot);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
