package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17210
 */
public class sml_17210_doorDoorDoor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        int way = Integer.parseInt(br.readLine());
        if (N > 5) {
            bw.write("Love is open door");
        } else {
            for (int i = 1; i < N; i++) {
                if (i % 2 == 1) {
                    bw.write(way == 0 ? "1\n" : "0\n");
                } else {
                    bw.write(way + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
