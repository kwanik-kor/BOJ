package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9517
 */
public class sml_09517_iLoveCroatia {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int bomb = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int tot = 0;
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tot += Integer.parseInt(st.nextToken());
            if (tot >= 210) break;
            if (st.nextToken().equals("T")) {
                bomb = (bomb + 1) % 9;
                if (bomb == 0) bomb++;
            }
        }
        bw.write(bomb + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
