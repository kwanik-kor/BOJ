package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sml_gahuiAndSoongsilUniv {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tot = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            tot += n * (type.equals("Es") ? 21 : 17);
        }
        System.out.println(tot);
    }

}
