package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25286
 */
public class sml_25286_november11th {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            LocalDate date = LocalDate.of(year, month, month).minusDays(month);
            bw.write(date.format(DateTimeFormatter.ofPattern("yyyy M dd\n")));
        }
        bw.close();
        br.close();
    }
}
