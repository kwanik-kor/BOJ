package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18409
 */
public class sml_18409_countingVowels {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        String word = br.readLine().replaceAll("[aeiou]", "");
        bw.write(len - word.length() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
