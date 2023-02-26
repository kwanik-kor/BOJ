package simulation;

import java.io.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6889
 */
public class sml_06889_smileWithSimiles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] adj = new String[n];
        String[] noun = new String[m];
        for (int i = 0; i < n; i++) {
            adj[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            noun[i] = br.readLine();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(String.format("%s as %s\n", adj[i], noun[j]));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
