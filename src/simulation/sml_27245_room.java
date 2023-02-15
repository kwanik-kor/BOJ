package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27245
 */
public class sml_27245_room {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int width = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        int height = Integer.parseInt(br.readLine());

        if (Math.min(width, length) / height >= 2 && Math.max(width, length) / Math.min(width, length) <= 2) {
            bw.write("good");
        } else {
            bw.write("bad");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
