import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int answer;

    public static Queue<Integer> q = new LinkedList<>();

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static void solution() throws Exception {

        for (int i = 1; i <= N; i++){
            q.offer(i);
        }

        int n;
        while(q.size() > 1) {
            q.poll();
            n = q.poll();
            q.offer(n);
        }

        answer = q.poll();
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        solution();

        bw.write("" + answer);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
