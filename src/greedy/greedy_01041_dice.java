package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class greedy_01041_dice {

    public static final long MAX_NUMBER_FLAG = 51L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Dice dice = new Dice(convertLineToLongArray(br.readLine()));

        if (N == 1) {
            bw.write(dice.oneDice() + "");
        } else {
            long sum = dice.getMinOne() * (N - 2) * (5 * N - 6)
                    + dice.getMinTwo() * 4 * (2 * N - 3)
                    + dice.getMinThree() * 4;
            bw.write(sum + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long[] convertLineToLongArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    private static class Dice {
        private final long[] dice;
        private final long minOne;
        private final long minTwo;
        private final long minThree;

        public Dice(long[] arr) {
            this.dice = arr;
            this.minOne = calculateMinOne(arr);
            this.minTwo = calculateMinTwo(arr);
            this.minThree = calculateMinThree(arr);
        }

        public long oneDice() {
            long sum = 0L;
            long max = 0L;
            for (int i = 0; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            return sum - max;
        }

        public long getMinOne() {
            return minOne;
        }

        public long getMinTwo() {
            return minTwo;
        }

        public long getMinThree() {
            return minThree;
        }

        private long calculateMinOne(long[] arr) {
            return Arrays.stream(arr)
                    .min()
                    .getAsLong();
        }

        private long calculateMinTwo(long[] arr) {
            long min = MAX_NUMBER_FLAG * 2;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (j != 5 - i) {
                        min = Math.min(min, arr[i] + arr[j]);
                    }
                }
            }
            return min;
        }

        private long calculateMinThree(long[] dice) {
            long min = MAX_NUMBER_FLAG * 3;
            long temp[] = {dice[0]+dice[1]+dice[2], dice[0]+dice[1]+dice[3], dice[0]+dice[2]+dice[4], dice[0]+dice[3]+dice[4], dice[1]+dice[2]+dice[5], dice[1]+dice[3]+dice[5], dice[2]+dice[4]+dice[5], dice[3]+dice[4]+dice[5]};
            for (int i = 0; i < 8; i++) {
                min = Math.min(min, temp[i]);
            }
            return min;
        }
    }
}
