import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, V; // 정점 개수, 간선 개수, 시작 정점

    public static ArrayList [] arr; // 인접 리스트
    public static int [] visited; // 방문 확인 배열

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int node) {
        visited[node] = 1; // 방문 정점 체크
        sb.append(node).append(" "); // 방문 정점 번호 문자열 추가

        for(int i = 0; i < arr[node].size(); i++){
            int next = (int) arr[node].get(i); // 다음 방문 정점에 대해,

            if(visited[next] == 1){ // 아직 방문하지 않았다면,
                continue;
            }

            dfs(next); // 재귀를 통한 DFS
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>(); // 큐를 활용한 BFS

        visited[start] = 1; // 시작 정점 방문 체크
        q.add(start); // 시작 정점 큐에 추가

        while(!q.isEmpty()){ // 큐가 비어있지 않을 때 까지
            int now = q.poll(); // 다음 방문 정점

            sb.append(now).append(" "); // 방문 정점 번호 문자열 추가

            for(Object n : arr[now]){ // 해당 정점의 인접한 정점들에 대해,
                if(visited[(int)n] == 1){ // 아직 방문하지 않았다면,
                    continue;
                }

                visited[(int)n] = 1; // 미리 방문 정점을 체크하고,
                q.add((int)n); // 모두 큐에 추가
            }
        }
    }

    public static void solution() throws IOException {
        dfs(V); // dfs 실행
        bw.write(sb.toString()); // 실행 결과 버퍼 추가
        bw.newLine(); // 개행 문자 버퍼 추가

        visited = new int [N + 1]; // 방문 확인 배열 초기화
        sb.setLength(0); // 스트링 빌더 초기화

        bfs(V); // bfs 실행
        bw.write(sb.toString()); // 실행 결과 버퍼 추가
        bw.newLine(); // 개행 문자 버퍼 추가
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수 입력
        M = Integer.parseInt(st.nextToken()); // 간선 개수 입력
        V = Integer.parseInt(st.nextToken()); // 시작 정점 입력

        visited = new int[N + 1]; // 방문 배열 초기화
        arr = new ArrayList[N + 1]; // 인접 리스트 초기화
        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<Integer>(); // 인접 리스트 생성
        }

        int n1, n2; // 정점 입력용 변수
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken()); // 정점1 입력
            n2 = Integer.parseInt(st.nextToken()); // 정점2 입력

            arr[n1].add(n2); // 양방향 그래프 이므로, 양쪽 정점에 대해 모두 추가
            arr[n2].add(n1);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arr[i]); // 번호가 작은 정점 부터 방문하기 위한 오름차순 정렬
        }

        solution(); // 풀이 함수 실행

        bw.close(); // 정답 버퍼 출력
    }
}
