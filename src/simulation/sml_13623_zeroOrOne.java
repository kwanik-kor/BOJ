package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13623
 */
public class sml_13623_zeroOrOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] in = new int[3];
        int one = 0;
        int oneIdx = 0;
        int zeroIdx = 0;
        for(int i = 0; i < 3; i++) {
            in[i] = Integer.parseInt(st.nextToken());
            if (in[i] == 1) {
                one++;
                oneIdx = i;
            } else {
                zeroIdx = i;
            }
        }
        if (one == 0 || one == 3) {
            bw.write("*");
        } else if (one == 1) {
            bw.write((char) (oneIdx + 'A'));
        } else {
            bw.write((char) (zeroIdx + 'A'));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
