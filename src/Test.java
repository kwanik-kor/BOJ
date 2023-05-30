import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0, n = arr.length; i < n; i++) {
            if (i == 0) {
                list.add(Integer.parseInt(arr[i]));
                continue;
            }
            if (Integer.parseInt(arr[i]) == Integer.parseInt(arr[i - 1])) {
                continue;
            }
            list.add(Integer.parseInt(arr[i]));  
        }

        for (Integer val : list) {
            System.out.println(val);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
