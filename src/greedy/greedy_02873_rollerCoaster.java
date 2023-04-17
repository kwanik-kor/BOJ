package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class greedy_02873_rollerCoaster {
    static final String DIRECTION = "URDL";
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int R, C;

    public static void main(String[] args) throws Exception {
        new greedy_02873_rollerCoaster().solve();
    }

    private void solve() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int minPointIdx = initializeAndGetMinPlace();
        if (R % 2 == 1 || C % 2 == 1) {
            bw.write(createAllNodePaths());
        }

        bw.close();
    }

    /**
     * 가로 혹은 세로 길이가 홀수인 경우 전체 경로를 탐색할 수 있음
     * @return 모든 노드를 탐색하는 경로
     */
    private String createAllNodePaths() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    private int initializeAndGetMinPlace() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int idx = 0, min = 1001;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (isNotStartOrEndPoint(i, j) && n <= min) {
                    idx = i * C + j;
                    min = n;
                }
            }
        }

        br.close();
        return idx;
    }

    private boolean isNotStartOrEndPoint(int y, int x) {
        int nodeIdx = y * C + x;
        return nodeIdx != 0 && nodeIdx != R * C - 1;
    }
}
