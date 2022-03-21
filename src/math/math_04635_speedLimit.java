package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4635
 */
public class math_04635_speedLimit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int set = Integer.parseInt(br.readLine());
            if(set == -1) break;

            StringTokenizer st;
            int lastTime = 0;
            int tot = 0;
            for(int i = 0; i < set; i++) {
                st = new StringTokenizer(br.readLine());
                int mile = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                tot += mile * (time - lastTime);
                lastTime = time;
            }
            bw.write(tot + " miles\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
