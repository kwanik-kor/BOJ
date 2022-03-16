package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1703
 */
public class sml_01703_growthPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0) break;

            int start = 1;
            for(int i = 0; i < a; i++) {
                int leaf = Integer.parseInt(st.nextToken());
                int cut = Integer.parseInt(st.nextToken());
                start *= leaf;
                start -= cut;
            }
            bw.write(start + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
