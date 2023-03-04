package simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10825
 */
public class sml_10825_kem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        while (N-- > 0) {
            students.add(new Student(br.readLine()));
        }
        Collections.sort(students);

        for (Student student : students) {
            bw.write(student.getName() + "\n");
        }
        bw.close();
        br.close();
    }

    static class Student implements Comparable<Student> {
        private String name;
        private int kor, eng, math;

        public Student(String line) {
            String[] arr = line.split(" ");
            this.name = arr[0];
            this.kor = Integer.parseInt(arr[1]);
            this.eng = Integer.parseInt(arr[2]);
            this.math = Integer.parseInt(arr[3]);
        }

        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }


        @Override
        public int compareTo(Student o) {
            if (o.getKor() == this.kor) {
                if (o.getEng() == this.eng) {
                    if (o.getMath() == this.math) {
                        return this.name.compareTo(o.getName());
                    }
                    return o.getMath() - this.math;
                }
                return this.eng - o.getEng();
            }
            return o.getKor() - this.kor;
        }
    }
}
