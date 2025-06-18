package simulation;

import java.io.*;

public class sml_28702_FizzBuzz {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int target;
        int next = 0;

        for (int i = 0; i < 3; i++) {
            try {
                target = Integer.parseInt(br.readLine());
                int quotient = target / 15;
                int mod = target % 15;

                next = target + (3 - i);
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }

        if (next % 15 == 0) {
            bw.write("FizzBuzz");
        } else if (next % 3 == 0) {
            bw.write("Fizz");
        } else if (next % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(next + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
