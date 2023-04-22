package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27590
 */
public class sml_27590_sunAndMoon {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sunStart = Integer.parseInt(st.nextToken());
        int sunDuration = Integer.parseInt(st.nextToken());

        sunStart = -sunStart + sunDuration;
        HashSet<Integer> set = new HashSet<>();
        while (sunStart <= 5000) {
            set.add(sunStart);
            sunStart += sunDuration;
        }

        st = new StringTokenizer(br.readLine());
        int moonStart = Integer.parseInt(st.nextToken());
        int moonDuration = Integer.parseInt(st.nextToken());
        moonStart = -moonStart + moonDuration;
        for (int i = 1; true; i++) {
            if (set.contains(moonStart)) {
                bw.write(moonStart + "");
                break;
            }
            moonStart += moonDuration;
        }
        bw.close();
        br.close();
    }

}
