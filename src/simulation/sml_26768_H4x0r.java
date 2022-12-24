package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26768
 */
public class sml_26768_H4x0r {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        line = line.replaceAll("a", "4");
        line = line.replaceAll("e", "3");
        line = line.replaceAll("i", "1");
        line = line.replaceAll("o", "0");
        line = line.replaceAll("s", "5");
        bw.write(line);
        bw.flush();
        bw.close();
        br.close();
    }
}
