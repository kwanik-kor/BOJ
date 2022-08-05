package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4732
 */
public class sml_04732_moveScore {

    private static final List<String> SCALE = Arrays.asList("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("***")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            List<Integer> idx = new ArrayList<>();
            while (st.hasMoreTokens()) {
                String scale = st.nextToken();
                if (SCALE.contains(scale)) {
                    idx.add(SCALE.indexOf(scale));
                } else {
                    int i = SCALE.indexOf(String.valueOf(scale.charAt(0)));
                    i += scale.charAt(1) == '#' ? 1 : -1;
                    if (i < 0) {
                        i = 11;
                    }
                    idx.add(i);
                }
            }
            int flag = Integer.parseInt(br.readLine());
            for (Integer i : idx) {
                int newIdx = i + flag;
                if (newIdx < 0) {
                    newIdx += 12;
                } else {
                    newIdx %= 12;
                }
                bw.write(SCALE.get(newIdx) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
