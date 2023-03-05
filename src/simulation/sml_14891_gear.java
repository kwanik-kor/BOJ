package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14891
 */
public class sml_14891_gear {
    static final char N = '0', S = '1';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Factory factory = new Factory();
        for (int i = 0; i < 4; i++) {
            factory.setGear(i, br.readLine());
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            factory.rotateGear(idx, idx, dir);
        }

        bw.write(factory.getScore() + "");
        bw.close();
        br.close();
    }

    static class Factory {
        Gear[] gears = new Gear[4];

        void setGear(int idx, String status) {
            this.gears[idx] = new Gear(status);
        }

        int getScore() {
            int tot = 0;
            for (int i = 0; i < 4; i++) {
                tot += gears[i].getGearValue(0) == '0' ? 0 : Math.pow(2, i);
            }
            return tot;
        }

        void rotateGear(int startIdx, int idx, int dir) {
            if (dir == 0) return;

            if (startIdx <= idx && idx < 3) {
                if (gears[idx].getGearValue(2) != gears[idx + 1].getGearValue(6)) {
                    rotateGear(startIdx, idx  + 1, -dir);
                } else {
                    rotateGear(startIdx, idx + 1, 0);
                }
            }

            if (0 < idx && idx <= startIdx) {
                if (gears[idx].getGearValue(6) != gears[idx - 1].getGearValue(2)) {
                    rotateGear(startIdx, idx - 1, -dir);
                } else {
                    rotateGear(startIdx, idx - 1, 0);
                }
            }

            gears[idx].rotate(dir);
        }
    }

    static class Gear {
        char[] status;

        public Gear(String line) {
            this.status = line.toCharArray();
        }

        char getGearValue(int idx) {
            return status[idx];
        }

        void rotate(int dir) {
            if (dir == 0) return;
            if (dir == 1) {
                char temp = status[7];
                for (int i = 7; i >= 1; i--) {
                    status[i] = status[i - 1];
                }
                status[0] = temp;
            } else {
                char temp = status[0];
                for (int i = 0; i <= 6; i++) {
                    status[i] = status[i + 1];
                }
                status[7] = temp;
            }
        }

    }
}
