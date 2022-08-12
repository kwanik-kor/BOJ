package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18698
 */
public class sml_18698_theWalkingAdam {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine();
            int idx = line.indexOf("D");
            bw.write(idx == -1 ? (line.length() + "\n") : (idx + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
