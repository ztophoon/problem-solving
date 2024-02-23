import java.io.*;
import java.util.*;

public class Solution {

    public static int testCase = 10;
    public static int start;
    public static List<Integer> [] adj;
    public static boolean [] visited;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution() {

        Queue<int []> q = new ArrayDeque();

        visited[start] = true;
        q.add(new int [] {start, 0});

        int maxN = 0;
        int maxCnt = 0;
        while(!q.isEmpty()){
            int [] popped = q.poll();
            int now = popped[0];
            int cnt = popped[1];

            if(cnt > maxCnt){
                maxCnt = cnt;
                maxN = now;
            } else if (cnt == maxCnt){
                maxN = Math.max(maxN, now);
            }

            for(int n : adj[now]){
                if(visited[n]){
                   continue;
                }

                visited[n] = true;
                q.add(new int [] {n, cnt + 1});
            }
        }

        return maxN;
    }

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= testCase; t++) {
            adj = new List [101];
            for(int i = 0; i < 101; i++){
                adj[i] = new ArrayList<>();
            }
            visited = new boolean [101];

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N / 2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(!adj[from].contains(to)){
                    adj[from].add(to);
                }
            }

            bw.write(String.format("#%d %d\n", t, solution()));
        }

        bw.close();
    }
}