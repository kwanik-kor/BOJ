package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26489
 */
public class sml_26489_gumGumJayJay {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        int cnt = 0;
        while ((line = br.readLine()) != null && !line.equals("")) {
            cnt++;
        }
        bw.write(cnt + "");
        bw.close();
        br.close();
    }
}
