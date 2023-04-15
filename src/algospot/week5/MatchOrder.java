package algospot.week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/MATCHORDER
 * 2. 풀이
 *  - 절대 이길수 없는 불곰이라면 가장 약한 선수를 출전시킴
 *  - 이길 수 있는 불곰이라면 가장 레이팅 차이가 작은 선수를 출전시킴
 *    - 해당 과정을 이중 for 문으로 해결했으나, binarySearch로 변경해서 풀어봄
 */
public class MatchOrder {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] russian = new int[101];
    static List<Integer> korean = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        MatchOrder main = new MatchOrder();

        int cases = Integer.parseInt(br.readLine());
        while (cases-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        int winCnt = 0;
        for (int i = 0; i < n; i++) {
            if (korean.get(korean.size() - 1) < russian[i]) {
                korean.remove(0);
            } else {
                korean.remove(binarySearch(russian[i]));
                winCnt++;
            }
        }

        bw.write(winCnt + "\n");
    }

    private void initialize() throws Exception {
        n = Integer.parseInt(br.readLine());

        StringTokenizer russia = new StringTokenizer(br.readLine());
        StringTokenizer korea = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            russian[i] = Integer.parseInt(russia.nextToken());
            korean.add(Integer.parseInt(korea.nextToken()));
        }
        Collections.sort(korean);
    }

    private int binarySearch(int target) {
        int left = 0, right = korean.size() - 1;

        int ret = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= korean.get(mid)) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ret;
    }

}
