package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6830
 */
public class sml_06830_itsColdHere {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        int max = 201;
        String ans = "";

        while ((line = br.readLine()) != null && !line.equals("")) {
            String[] arr = line.split(" ");
            if (Integer.parseInt(arr[1]) < max) {
                max = Integer.parseInt(arr[1]);
                ans = arr[0];
            }
        }

        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}
