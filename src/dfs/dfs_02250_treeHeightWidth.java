package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2250
 * 2. 풀이
 *  - 중위탐색으로 트리를 순회하는 문제
 *   > 중위탐색(Inorder) : LEFT > ROOT > RIGHT
 *  - 중위탐색을 진행해야하는 이유는, 왼쪽에서 부터 column이 하나씩 밀려나야 하기 때문이다.
 *   > 다만, 현재 문제에서는 depth에 따른 최소, 최대 값을 찾아야 하기 때문에 min / max를 탐색시에 산출해 둔다.
 *  - 문제에서 제시된 테이블을 잘 보게되면, 각 Column 번호는 중위탐색을 실행했을때 탐색되는 순서와 동일하다.
 *   > 이에 dfs() 호출부에서 nodeCol[node] = col 을 선언하면 해당 노드의 컬럼번호를 얻을 수 있다.
 */
public class dfs_02250_treeHeightWidth {

    static final int INF = 987654321;

    static int N, root, col = 1;
    static int[] findRoot, min, max;
    static Node[] nodes;

    static void dfs(int node, int row) {
        if(nodes[node].l != -1)
            dfs(nodes[node].l, row + 1);

        min[row] = Math.min(min[row], col);
        max[row] = Math.max(max[row], col++);

        if(nodes[node].r != -1)
            dfs(nodes[node].r, row + 1);
    }

    // 너비가 가장 넓은 레벨과 그 레벨을 출력하시오
    //  > 너비 : 레벨에서 가장 우측 노드 열번호 - 가장 좌측 노드 열번호 + 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        findRoot = new int[N + 1];
        min = new int[N + 1];
        max = new int[N + 1];
        Arrays.fill(min, INF);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodes[node] = new Node(l, r);
            findRoot[node]++;
            if(l != -1) findRoot[l]++;
            if(r != -1) findRoot[r]++;
        }

        for(int i = 1; i <= N; i++) {
            if(findRoot[i] == 1) {
                root = i;
                break;
            }
        }

        dfs(root, 1);

        int row = 1;
        int width = 1;
        for(int i = 1; i <= N; i++) {
            if(min[i] == INF) break;
            int tempWidth = max[i] - min[i] + 1;
            if(width < tempWidth) {
                row = i;
                width = tempWidth;
            }
        }

        bw.write(row + " " + width);
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        Integer l, r;
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public void setL(Integer l) {
            this.l = l;
        }

        public void setR(Integer r) {
            this.r = r;
        }
    }
}
