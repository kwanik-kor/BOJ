package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/28114
 */
public class sml_28114_makeTeamName {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            members.add(new Member(br.readLine()));
        }

        bw.write(getFirstMethodTeamName(members) + "\n");
        bw.write(getSecondMethodTeamName(members) + "\n");
        bw.close();
        br.close();
    }

    private static String getFirstMethodTeamName(List<Member> members) {
        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.year % 100 - o2.year % 100;
            }
        });

        return members.stream()
                .map(member -> String.valueOf(member.getYear() % 100))
                .reduce((a, b) -> a + b)
                .get();
    }

    private static String getSecondMethodTeamName(List<Member> members) {
        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o2.solvedCnt - o1.solvedCnt;
            }
        });

        return members.stream()
                .map(member -> String.valueOf(member.getName().charAt(0)))
                .reduce((a, b) -> a + b)
                .get();
    }

    private static class Member {
        private int solvedCnt;
        private int year;
        private String name;

        public Member(String line) {
            StringTokenizer st = new StringTokenizer(line);
            this.solvedCnt = Integer.parseInt(st.nextToken());
            this.year = Integer.parseInt(st.nextToken());
            this.name = st.nextToken();
        }

        public int getSolvedCnt() {
            return solvedCnt;
        }

        public int getYear() {
            return year;
        }

        public String getName() {
            return name;
        }
    }
}
