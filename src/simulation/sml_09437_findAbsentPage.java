package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9437
 */
public class sml_09437_findAbsentPage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            int P = Integer.parseInt(st.nextToken());
            int idx = (P - 1) / 2;
            if (P > N / 2) {
                idx = (N - P) / 2;
            }
            int[] arr = new int[4];
            arr[0] = idx * 2 + 1;
            arr[1] = arr[0] + 1;
            arr[3] = N - (idx * 2);
            arr[2] = arr[3] - 1;
            for(int i = 0; i < 4; i++) {
                if(arr[i] == P) continue;
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
