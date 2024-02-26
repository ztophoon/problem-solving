import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static Stack<int []> jobs = new Stack<int []>();

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution() throws IOException {
        int [] nowJob = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int job = Integer.parseInt(st.nextToken());

            if(job == 0) {
                if(nowJob != null){
                    nowJob[1]--;
                }
            } else {
                if(nowJob != null) {
                    jobs.push(nowJob);
                }

                int reward = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                nowJob = new int [] {reward, time - 1};
            }

            if(nowJob != null && nowJob[1] == 0) {
                answer += nowJob[0];
                if(!jobs.isEmpty()) {
                    nowJob = jobs.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        solution();

        bw.write(String.format("%d", answer));
        bw.close();
    }
}
