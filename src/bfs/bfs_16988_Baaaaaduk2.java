package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_16988_Baaaaaduk2 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        bw.flush();
        bw.close();
        br.close();
    }
}
