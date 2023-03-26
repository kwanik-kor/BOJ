package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11005
 */
public class sml_11005_changeMatrix {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Integer.toString(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).toUpperCase());
    }
}
