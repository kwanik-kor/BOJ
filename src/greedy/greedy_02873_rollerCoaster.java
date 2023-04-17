package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class greedy_02873_rollerCoaster {
    static final String DIRECTION = "UD";
    static final int[] dy = {-1, 1};

    static int R, C;

    public static void main(String[] args) throws Exception {
        new greedy_02873_rollerCoaster().solve();
    }

    private void solve() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int minPointIdx = initializeAndGetMinPlace();
        if (R % 2 == 1 || C % 2 == 1) {
            bw.write(createAllNodePaths());
        } else {
            bw.write(createEvenPaths(minPointIdx));
        }

        bw.close();
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
                if (isNodeToCheckMinPoint(i, j) && n <= min) {
                    idx = i * C + j;
                    min = n;
                }
            }
        }

        br.close();
        return idx;
    }

    /**
     * 가로 혹은 세로 길이가 홀수인 경우 전체 경로를 탐색할 수 있음
     *  - 행 개수가 짝수인 경우 (아래 > 오른쪽 > 위)
     *  - 행 개수가 홀수인 경우 (오른쪽 > 아래 > 왼쪽)
     * @return 모든 노드를 탐색하는 경로
     */
    private String createAllNodePaths() {
        StringBuilder sb = new StringBuilder();
        int first = getAllNodePathFirstDimensionMax();
        int second = getAllNodePathSecondDimensionMax();
        char[] directions = getAllNodePathDirections();

        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                sb.append(i % 2 == 0 ? directions[0] : directions[1]);
            }
            if (i != first - 1) {
                sb.append(directions[2]);
            }
        }

        return sb.toString();
    }

    private String createEvenPaths(int minIdx) {
        StringBuilder sb = new StringBuilder();

        int minRow = minIdx / C;

        boolean startFromLeft = true;
        for (int row = 0, max = R / 2; row < max; row++) {
            if (row * 2 == minRow || (row * 2 + 1) == minRow) {
                sb.append(colFirstSearch(row * 2, minIdx));
                startFromLeft = false;
            } else {
                sb.append(rowFirstSearch(row * 2, startFromLeft));
            }
        }
        return sb.toString();
    }

    private String rowFirstSearch(int startRow, boolean startFromLeft) {
        StringBuilder sb = new StringBuilder();

        char[] directions = getRowSearchDirections(startFromLeft);
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < C - 1; x++) {
                sb.append(directions[y]);
            }
            if (y == 0) {
                sb.append('D');
            }
        }
        if (startRow + 1 != R - 1) {
            sb.append('D');
        }

        return sb.toString();
    }

    private String colFirstSearch(int startRow, int passNodeIdx) {
        StringBuilder sb = new StringBuilder();

        int colDirection = 1;
        int y = startRow;
        for (int x = 0; x < C; x++) {
            int ny = y + dy[colDirection];

            if (ny == passNodeIdx / C && x == passNodeIdx % C) {
                if (!(ny == R - 1 && x == C - 1)) {
                    sb.append('R');
                }
                continue;
            }

            sb.append(DIRECTION.charAt(colDirection));
            if (!((ny == R - 1 || ny + 1 == R - 1) && (x + 1 == C - 1 || x == C - 1))) {
                sb.append('R');
            }
            y = ny;
            colDirection ^= 1;
        }

        if (startRow + 1 != R - 1) {
            sb.append('D');
        }

        return sb.toString();
    }

    private boolean isNodeToCheckMinPoint(int y, int x) {
        return (y + x) % 2 == 1;
    }

    private int getAllNodePathFirstDimensionMax() {
        return R % 2 == 0 ? C : R;
    }

    private int getAllNodePathSecondDimensionMax() {
        return (R % 2 == 0 ? R : C) - 1;
    }

    private char[] getAllNodePathDirections() {
        return R % 2 == 0
                ? new char[]{'D', 'U', 'R'}
                : new char[]{'R', 'L', 'D'};
    }

    private char[] getRowSearchDirections(boolean startFromLeft) {
        return startFromLeft
                ? new char[]{'R', 'L'}
                : new char[]{'L', 'R'};
    }
}
