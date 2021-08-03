package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_05931_cowBeautyPageant {

    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.flush();
        bw.close();
        br.close();
    }
}
