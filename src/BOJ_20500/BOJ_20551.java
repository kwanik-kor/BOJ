package BOJ_20500;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20551 {

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (list.get(mid).compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left < list.size() && list.get(left).equals(target)) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int i = 0; i < m; i++) {
            bw.write(lowerBound(list, Integer.parseInt(br.readLine())) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
