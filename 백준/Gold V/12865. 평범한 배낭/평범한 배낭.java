import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int [] W, V;
    public static int [][] DP, visited;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution(int num, int weight) throws IOException {
        if(visited[num][weight] == 1){
            return DP[num][weight];
        }

        if(num == 1){
            if(W[num] <= weight) {
                return V[num];
            } else {
                return 0;
            }
        }

        visited[num][weight] = 1;
        if(weight - W[num] >= 0){
            DP[num][weight] = Math.max(solution(num - 1, weight), solution(num - 1, weight - W[num]) + V[num]);
        } else {
            DP[num][weight] = solution(num - 1, weight);
        }

        return DP[num][weight];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[N + 1];
        DP = new int[N + 1][K + 1];
        visited = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(N, K) + "");
        bw.close();
    }
}
