import java.io.*;
import java.util.*;

public class Solution {

    public static int testCase = 10;
    public static int N = 8;

    public static Queue<Integer> q = new ArrayDeque<>();

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static int solution() {
        int now, ans = 0;

        lb: while(true){
                for(int i = 1; i <= 5; i++){
                    now = q.poll();

                    now = now - i > 0 ? now - i : 0;
                    q.add(now);

                    if(now == 0){
                        break lb;
                    }
                }
            }

        for(int i = 0; i < N; i++){
            sb.append(q.poll()).append(" ");
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        for (int t = 1; t <= testCase; t++) {
            br.readLine(); // dump

            q.clear();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                q.add(Integer.parseInt(st.nextToken()));
            }

            sb.append("#").append(t).append(" ");
            solution();
            sb.append("\n");

            bw.write(sb.toString());
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
    }
}
