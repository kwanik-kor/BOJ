package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/3015
 * 2. 풀이
 *  - Brute Force로 처리하게 되면 가볍게 압도적인 연산량이 나와버린다.
 *  - 들어오는 Query에 대해 즉각즉각 연산을 처리해나가야 하는데, 이를 위해서는 Stack을 사용해야 함.
 *    > DP와 유사하게, 이전까지 경우의 수와 키를 Stack에 저장해 둔다.
 */
public class ds_stack_03015_oasisReunion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long ans = 0L;
        Stack<Person> stack = new Stack<>();
        while(N-- > 0) {
            int h = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek().height < h)
                ans += stack.pop().cnt;

            if(stack.isEmpty()) {
                stack.push(new Person(h, 1L));
            } else {
                if(stack.peek().height == h) {
                    Person p = stack.pop();
                    ans += p.cnt;

                    if(!stack.isEmpty())
                        ans++;

                    stack.push(new Person(h, p.cnt + 1));
                } else { // 높이가 더 낮다면
                    stack.push(new Person(h, 1L));
                    ans++;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Person {
        int height;
        long cnt;
        public Person(int height, long cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

}
