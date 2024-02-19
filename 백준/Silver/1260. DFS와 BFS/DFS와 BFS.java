import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, V;

    public static ArrayList [] arr;
    public static int [] visited;

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int node) {
        visited[node] = 1;
        sb.append(node).append(" ");

        for(int i = 0; i < arr[node].size(); i++){
            int next = (int) arr[node].get(i);

            if(visited[next] == 1){
                continue;
            }

            dfs(next);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = 1;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            sb.append(now).append(" ");

            for(Object n : arr[now]){
                if(visited[(int)n] == 1){
                    continue;
                }

                visited[(int)n] = 1;
                q.add((int)n);
            }
        }
    }

    public static void solution() throws IOException {
        dfs(V);
        bw.write(sb.toString());
        bw.newLine();

        visited = new int [N + 1];
        sb.setLength(0);

        bfs(V);
        bw.write(sb.toString());
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        arr = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        int n1, n2;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arr[i]); // 번호가 작은 정점 부터 방문하기 위한 오름차순 정렬
        }

        solution();

        bw.close();
    }
}
