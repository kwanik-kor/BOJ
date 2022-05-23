package recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17478
 */
public class recursive_17478_whatIsRecursive {

    private static int N;
    private static final String[] LOOP = {"\"재귀함수가 뭔가요?\"\n"
            , "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
            , "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
            , "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
    private static final String[] LAST_LOOP = {
            "\"재귀함수가 뭔가요?\"\n"
            , "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
    };

    private static final String ANSWER = "라고 답변하였지.\n";

    public static String print(int idx) {
        StringBuilder flag = new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        for (int j = 0; j < idx * 4; j++) {
            flag.append("_");
        }
        if (idx == N) {
            for (int i = 0; i < 2; i++) {
                sb.append(flag.toString() + LAST_LOOP[i]);
            }
            sb.append(flag.toString() + ANSWER);
            return sb.toString();
        } else {
            for (int i = 0; i < 4; i++) {
                sb.append(flag.toString() + LOOP[i]);
            }
            sb.append(print(idx + 1));
            sb.append(flag.toString() + ANSWER);
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        sb.append(print(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
