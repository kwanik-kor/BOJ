package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6825
 */
public class sml_06825_bodyMassIndex {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        double bmi = weight / (height * height);
        if (bmi > 25.0d) {
            bw.write("Overweight");
        } else if (bmi >= 18.5) {
            bw.write("Normal weight");
        } else {
            bw.write("Underweight");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
