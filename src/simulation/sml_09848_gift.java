package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sml_09848_gift {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int cnt = 0;
        arr[0] = Integer.parseInt(br.readLine());
        for(int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i - 1] - arr[i] >= k) cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
