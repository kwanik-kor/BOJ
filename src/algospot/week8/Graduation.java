package algospot.week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graduation {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    static int major, required, semesterCnt, max;
    static int[] prerequisites = new int[12];
    static int[] classes = new int[10];
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        Graduation main = new Graduation();

        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            main.solve();
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        int result = checkGraduateSemester(0, 0);
        sb.append(result == INF ? "IMPOSSIBLE" : String.valueOf(result)).append("\n");
    }

    private int checkGraduateSemester(int semester, int checked) {
        if (Integer.bitCount(checked) >= required) {
            return 0;
        }
        if (semester == semesterCnt) {
            return INF;
        }
        if (memo[semester][checked] != -1) {
            return memo[semester][checked];
        }

        memo[semester][checked] = INF;

        int notChecked = (classes[semester] & ~checked);
        for (int i = 0; i < major; i++) {
            if ((notChecked & (1 << i)) != 0 && (checked & prerequisites[i]) != prerequisites[i]) {
                notChecked &= ~(1 << i);
            }
        }

        for (int i = notChecked; i > 0; i = ((i - 1) & checked)) {
            if (Integer.bitCount(i) > max) {
                continue;
            }
            memo[semester][checked] = Math.min(memo[semester][checked], checkGraduateSemester(semester + 1, i | checked) + 1);
        }
        memo[semester][checked] = Math.min(memo[semester][checked], checkGraduateSemester(semester + 1, checked));

        return memo[semester][checked];
    }

    private void initialize() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        major = Integer.parseInt(st.nextToken());
        required = Integer.parseInt(st.nextToken());
        semesterCnt = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        memo = new int[10][1 << 10];

        initializePrerequisites();
        initializeClasses();
    }

    private void initializePrerequisites() throws Exception {
        Arrays.fill(prerequisites, 0);

        for (int i = 0; i < major; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prerequisiteCnt = Integer.parseInt(st.nextToken());
            while (prerequisiteCnt-- > 0) {
                int prerequisite = Integer.parseInt(st.nextToken());
                prerequisites[i] |= (1 << prerequisite);
            }
        }
    }

    private void initializeClasses() throws Exception {
        Arrays.fill(classes, 0);

        for (int i = 0; i < semesterCnt; i++) {
            Arrays.fill(memo[i], -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int classCnt = Integer.parseInt(st.nextToken());
            while (classCnt-- > 0) {
                int subject = Integer.parseInt(st.nextToken());
                classes[i] |= (1 << subject);
            }
        }
    }


}
