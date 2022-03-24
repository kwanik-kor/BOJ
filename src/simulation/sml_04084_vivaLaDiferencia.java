package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4084
 */
public class sml_04084_vivaLaDiferencia {

    static int getCnt(int cnt, int[] arr) {
        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3])
            return cnt;
        int[] temp = new int[4];
        for(int i = 0; i < 4; i++) {
            temp[i] = Math.abs(arr[i] - arr[(i + 1) % 4]);
        }
        return getCnt(cnt + 1, temp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for(int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) break;
            bw.write(getCnt(0, arr) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
