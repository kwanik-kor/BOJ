package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3512
 */
public class sml_03512_flat {

    static final String[] TYPE = {"bedroom", "bathroom", "kitchen", "balcony", "other"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<String, Float> width = new HashMap<>();
        for (String type : TYPE)  {
            width.put(type, 0f);
        }

        float tot = 0f;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            float w = Float.parseFloat(st.nextToken());
            String type = st.nextToken();
            width.put(type, width.get(type) + w);
            tot += w;
        }

        bw.write(String.format("%d\n%.0f\n", (int) tot, width.get("bedroom")));
        bw.write(String.format("%.6f", C * (tot - width.get("balcony") / 2)));
        bw.flush();
        bw.close();
        br.close();
    }
}
