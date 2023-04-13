package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27918
 */
public class sml_27918_tableTennis {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int d = 0, p = 0;
        while (N-- > 0) {
            if (br.readLine().charAt(0) == 'D') {
                d++;
            } else {
                p++;
            }
            if (Math.abs(d - p) >= 2) {
                break;
            }
        }

        bw.write(d + ":" + p);
        bw.close();
        br.close();
    }

}
