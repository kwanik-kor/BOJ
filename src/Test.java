import java.util.Scanner;

public class Test {

    static int[][][] maps = new int[3][6][6]; // 입력된 전개도를 저장할 배열
    static boolean[] visited = new boolean[6]; // DFS 탐색 시 방문 여부를 저장할 배열
    static int[][] adj = {{1, 3, 4}, {0, 2, 4}, {1, 5, 4}, {0, 4, 5}, {0, 1, 2, 3}, {2, 3, 4, 5}}; // 인접한 면의 인덱스를 저장한 배열
    static boolean found; // 정육면체를 찾았는지 여부를 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력된 전개도를 저장
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                String[] input = sc.nextLine().split(" ");
                for (int k = 0; k < 6; k++) {
                    maps[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }

        // 세 전개도에 대해 DFS 탐색
        for (int i = 0; i < 3; i++) {
            found = false;
            dfs(i, 0);
            if (found) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    // DFS 탐색 함수
    static void dfs(int mapIndex, int depth) {
        if (depth == 6) { // 모든 면을 방문한 경우
            found = true;
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                boolean match = true;
                for (int j = 0; j < adj[i].length; j++) {
                    int adjIndex = adj[i][j];
                    int row = adjIndex / 3;
                    int col = adjIndex % 3;
                    if (maps[mapIndex][row][col] != 1) { // 인접한 면이 맞지 않는 경우
                        match = false;
                        break;
                    }
                }

                if (match) { // 인접한 면이 맞는 경우
                    visited[i] = true;
                    dfs(mapIndex, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
