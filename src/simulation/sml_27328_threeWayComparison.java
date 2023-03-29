package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27328
 */
public class sml_27328_threeWayComparison {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.compare(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
    }
}
