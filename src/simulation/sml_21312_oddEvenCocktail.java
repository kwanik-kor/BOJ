package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/21312
 */
public class sml_21312_oddEvenCocktail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] flavor = new int[3];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            flavor[i] = Integer.parseInt(st.nextToken());
            list.add(flavor[i]);
        }

        list.add(flavor[0] * flavor[1]);
        list.add(flavor[1] * flavor[2]);
        list.add(flavor[2] * flavor[0]);
        list.add(flavor[0] * flavor[1] * flavor[2]);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == o2 % 2) {
                    return o1 - o2;
                }
                return o1 % 2 - o2 % 2;
            }
        });
        bw.write(list.get(6) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
