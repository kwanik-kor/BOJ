package simulation;

import java.io.*;

public class sml_31403_ABC {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write((a + b - c) + "\n" + (Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c));
        bw.flush();
        bw.close();
        br.close();
    }
}
