import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static Queue<Integer> q = new ArrayDeque<>();

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution(){
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            for(int i = 0; i < K-1; i++){
                q.add(q.poll());
            }
            sb.append(q.poll());
            if(!q.isEmpty()){
                sb.append(", ");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb.append("<");
        solution();
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
