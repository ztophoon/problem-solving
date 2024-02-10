import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static List<Integer> li = new LinkedList<>();

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution(){

        for(int i = 1; i <= N; i++){
            li.add(i);
        }

        int idx = 0;
        while(li.size() > 0){
            idx = (idx + (K - 1)) % li.size();
            sb.append(li.remove(idx));
            if(li.size() > 0) {
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
