package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ds_trie_12054_ipAdressSumarize {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(String.format("Case #%d:\n", t));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
