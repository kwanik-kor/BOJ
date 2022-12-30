package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5358
 */
public class sml_05358_footballTeam {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        while ((line = br.readLine()) != null && !line.equals("")) {
            char[] arr = line.toCharArray();
            for (int i = 0, n = arr.length; i < n; i++) {
                if (arr[i] == 'i') {
                    bw.write('e');
                } else if (arr[i] == 'e') {
                    bw.write('i');
                } else if (arr[i] == 'I') {
                    bw.write('E');
                } else if (arr[i] == 'E') {
                    bw.write('I');
                } else {
                    bw.write(arr[i]);
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
