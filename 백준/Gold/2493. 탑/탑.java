import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int [] tops;

    public static Stack<Integer> topStack = new Stack<>();
    public static Stack<Integer> idxStack = new Stack<>();

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution() throws IOException {
        for(int i = 0; i < N; i++){
            while(!topStack.empty() && topStack.peek() < tops[i]){
                topStack.pop();
                idxStack.pop();
            }

            if(!topStack.empty()) {
                sb.append(idxStack.peek()).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            topStack.push(tops[i]);
            idxStack.push(i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tops = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tops[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
