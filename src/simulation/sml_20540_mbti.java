package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/20540
 */
public class sml_20540_mbti {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        for (int i = 0; i < 4; i++) {
            line[i] = opposite(line[i]);
        }
        bw.write(String.valueOf(line));
        bw.flush();
        bw.close();
        br.close();
    }

    private static char opposite(char c) {
        switch (c) {
            case 'E': return 'I';
            case 'I': return 'E';
            case 'N': return 'S';
            case 'S': return 'N';
            case 'T': return 'F';
            case 'F': return 'T';
            case 'P': return 'J';
            default: return 'P';
        }
    }
}
