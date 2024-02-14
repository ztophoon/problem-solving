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
        if(visited[num][weight] == 1){ // 중복 연산 방지
            return DP[num][weight];
        }

        if(num == 1){ // base condition : 첫 번째 물건 도달 시 무게 조건에 따라 담을 수 있으면 담고, 아니면 0
            if(W[num] <= weight) {
                return V[num];
            } else {
                return 0;
            }
        }

        // 결국 num번째의 물건을 담느냐, 안 담느냐의 차이
        // DP[num][weight] : 가방 속 num개의 물건들의 무게의 합이 weight 일 때의 최대 value
        visited[num][weight] = 1;
        if(weight - W[num] >= 0){ // num번째 물건을 담아도 무게 제한이 초과되지 않는 경우
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
