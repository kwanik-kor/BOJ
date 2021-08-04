package bfs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 진행 중인 게임을 회전시켜도 답이 바뀌지는 않습니다.
 * 두 지목권의 위치를 상대 위치로 관리하면 상태가 2𝑁 개로
 * 줄어듭니다.
 */
public class bfs_14705_redGinsengGameHard {

    static int N, A, B, dA, dB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dA = Integer.parseInt(st.nextToken());
        dB = Integer.parseInt(st.nextToken());


        bw.flush();
        bw.close();
        br.close();
    }
}
