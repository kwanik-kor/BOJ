package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *  1. 문제 링크 : https://www.acmicpc.net/problem/1897
 *  2. 풀이
 *   - 토를 달 때마다 글자수가 하나씩 증가하기 때문에, 첫 입력을 받을 때 글자 수 별로 단어를 grouping 처리해 둠
 *   - bfs를 이용해 첫 번째 단어에 토를 달 수 있는지 검사함
 */
public class bfs_01897_makeExcuse {

    static int d;
    static String ans;
    static Map<Integer, List<String>> words = new HashMap<>();

    static void solve(String firstWord) {
        Queue<String> q = new LinkedList<>();

        Set<String> set = new HashSet<>();
        set.add(firstWord);
        q.add(firstWord);
        ans = firstWord;

        while(!q.isEmpty()) {
            String now = q.poll();
            ans = now;
            for(String word : words.getOrDefault(now.length() + 1, new ArrayList<>())) {
                if(set.contains(word)) continue;
                if(check(now, word)) {
                    set.add(word);
                    q.add(word);
                }
            }
        }

    }

    static boolean check(String origin, String excuse) {
        boolean flag = true;

        int idx = 0;
        for(int i = 0, n = excuse.length(); i < n; i++) {
            if(idx == origin.length()) return true;
            if (excuse.charAt(i) == origin.charAt(idx)) {
                idx++;
                continue;
            }
            // 두 개 이상이 다른경우
            if(!flag) return false;
            flag = false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        String start = st.nextToken();

        List<String> dict = new ArrayList<>();
        for(int i = 0; i < d; i++) {
            dict.add(br.readLine());
        }
        words = dict.stream().collect(Collectors.groupingBy(String::length));

        solve(start);

        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
}
