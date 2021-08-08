package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_02479_findPath {

    static int N, K;
    static String[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nodes = new String[N + 1];
        for(int i = 1; i <= N; i++) {
            nodes[i] = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
