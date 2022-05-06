package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sml_02029_matches {

    static char[][] map = new char[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int dash = 48;
        for(int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < 10; j++) {
                if (map[i][j] == '-' || map[i][j] == '|') {
                    dash--;
                }
            }
        }

        bw.write(dash + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
