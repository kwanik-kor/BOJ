package simulation;

import java.io.IOException;
import java.util.Scanner;

public class sml_24883_autoComplete {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().toUpperCase().equals("N") ? "Naver D2" : "Naver Whale");
    }
}
