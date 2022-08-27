package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11121
 * 2. 풀이
 *  - 단순 구현 문제
 *  - 입력받은 두 문자열의 각 자리 별로 다른 문자열이 있는지 체크
 */
public class sml_11121_communicationChannel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            boolean flag = true;
            for (int i = 0, n = line[0].length(); i < n; i++) {
                if (line[0].charAt(i) != line[1].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            bw.write(flag ? "OK\n" : "ERROR\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
