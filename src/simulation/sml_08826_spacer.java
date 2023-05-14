package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/8826
 */
public class sml_08826_spacer {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] seq = br.readLine().toCharArray();
            int vertical = 0;
            int horizontal = 0;
            for (int i = 0; i < n; i++) {
                switch (seq[i]) {
                    case 'E': horizontal++; break;
                    case 'W': horizontal--; break;
                    case 'N': vertical++; break;
                    default: vertical--;
                }
            }
            bw.write(Math.abs(vertical) + Math.abs(horizontal) + "\n");
        }
        bw.close();
        br.close();
    }

}
