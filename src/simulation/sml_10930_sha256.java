package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10930
 * 2. 풀이
 *  - 자바에서 SHA-256 해싱을 사용할 수 있는지 확인하는 문제
 */
public class sml_10930_sha256 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : md.digest()) {
            sb.append(String.format("%02x", b));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
