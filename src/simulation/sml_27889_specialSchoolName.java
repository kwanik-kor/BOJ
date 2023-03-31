package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27889
 */
public class sml_27889_specialSchoolName {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (br.readLine()) {
            case "NLCS":
                System.out.println("North London Collegiate School");
                break;
            case "BHA":
                System.out.println("Branksome Hall Asia");
                break;
            case "KIS":
                System.out.println("Korea International School");
                break;
            default:
                System.out.println("St. Johnsbury Academy");
        }
    }
}
