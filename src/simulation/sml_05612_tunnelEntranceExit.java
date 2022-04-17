package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5612
 */
public class sml_05612_tunnelEntranceExit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int max = cnt;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cnt += a - b;
            if(max < cnt) {
                max = cnt;
            }
            if(cnt < 0) {
                max = 0;
                break;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
