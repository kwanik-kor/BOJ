package algospot.week10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/TRAVERSAL
 */
public class Traversal {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Traversal main = new Traversal();

        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        br.readLine();

        List<Integer> preOrder = getSequence();
        List<Integer> inOrder = getSequence();

        StringBuilder sb = new StringBuilder();

        postOrder(preOrder, inOrder, sb);

        bw.write(sb.toString().trim() + "\n");
    }

    private void postOrder(List<Integer> preOrder, List<Integer> inOrder, StringBuilder sb) {
        if (preOrder == null || preOrder.size() == 0) {
            return;
        }

        final int N = preOrder.size();
        final int root = preOrder.get(0);

        int rootIndex = inOrder.indexOf(root);
        postOrder(preOrder.subList(1, rootIndex + 1), inOrder.subList(0, rootIndex), sb);

        postOrder(preOrder.subList(rootIndex + 1, N), inOrder.subList(rootIndex + 1, N), sb);

        sb.append(root).append(" ");
    }

    private List<Integer> getSequence() throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
