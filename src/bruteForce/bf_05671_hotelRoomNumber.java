package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5671
 */
public class bf_05671_hotelRoomNumber {

    static boolean isIterable(int n) {
        boolean[] flag = new boolean[10];
        char[] arr = String.valueOf(n).toCharArray();
        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] - '0';
            if (flag[idx]) return false;
            flag[idx] = true;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String in = br.readLine();
            if(in == null || in.equals(""))
                break;
            StringTokenizer st = new StringTokenizer(in);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i = N; i <= M; i++) {
                if(isIterable(i)) cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
