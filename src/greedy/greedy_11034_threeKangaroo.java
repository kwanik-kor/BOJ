package greedy;

import java.io.*;
import java.util.StringTokenizer;

public class greedy_11034_threeKangaroo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";

        while(true) {
            str = br.readLine();
            if(str == null || str.equals(""))
                break;

            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int ans = 0;
            if(!(b - a == 1 && c - b == 1)) {
                ans = Math.max(b - a, c - b) - 1;
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
