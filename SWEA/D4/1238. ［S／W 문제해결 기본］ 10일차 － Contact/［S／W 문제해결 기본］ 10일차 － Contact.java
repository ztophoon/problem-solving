import java.io.*;
import java.util.*;

/*
 * 그래프를 시작 정점에서 BFS로 탐색, 매 탐색 시 탐색 깊이 depth를 증가 시킴
 * cnt 값이 증가할 때 마다 방문 정점의 최대값을 초기화 -> 가장 깊은 depth에서 정점의 최대값을 정답으로 반환
 */

public class Solution {

    public static int testCase = 10; // 테스트케이스
    public static int start;         // 시작 정점
    public static List<Integer> [] adj; // 인접리스트
    public static boolean [] visited;   // 방문 확인 배열

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution() {

        Queue<int []> q = new ArrayDeque(); // BFS 구현을 위한 큐 -> 원소의 형태 : {node, depth}

        visited[start] = true;        // 시작 정점 방문 표시
        q.add(new int [] {start, 0}); // 시작 정점 큐 push -> {node = start, depth = 0}

        int maxN = 0;   // 최대 정점 번호
        int maxDepth = 0; // 최대 탐색 깊이 depth
        while(!q.isEmpty()){
            int [] popped = q.poll(); // 배열 형태의 원소를 큐에서 pop
            int now = popped[0];   // pop된 배열에서 값 추출 : node 번호
            int depth = popped[1]; // pop된 배열에서 깊이 추출 : depth

            if(depth > maxDepth){ // 최대 깊이가 갱신되면
                maxDepth = depth; // 최대 값을 바꾸고
                maxN = now;       // 그때의 정점 번호를 저장
            } else if (depth == maxDepth){  // 이후 최대 깊이의 탐색이 진행될 때
                maxN = Math.max(maxN, now); // 정점 번호의 최대값을 갱신
            }

            for(int n : adj[now]){ // 인접 리스트를 순회하며 인접 노드 탐색
                if(visited[n]){ // 방문 확인
                   continue;
                }

                visited[n] = true; // 방문 배열 체크
                q.add(new int [] {n, depth + 1}); // 큐 push
            }
        }

        return maxN; // 탐색이 종료되면 최대 정점 번호 반환
    }

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= testCase; t++) {
            adj = new List [101]; // 인접 리스트 초기화
            for(int i = 0; i < 101; i++){
                adj[i] = new ArrayList<>();
            }
            visited = new boolean [101]; // 방문 배열 초기화

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 입력 개수 입력
            start = Integer.parseInt(st.nextToken()); // 시작 정점 입력

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N / 2; i++){
                int from = Integer.parseInt(st.nextToken()); // from 정보 입력
                int to = Integer.parseInt(st.nextToken()); // to 정보 입력

                if(!adj[from].contains(to)){ // 입력이 중복될 수 있으므로 이미 입력된 간선이 아니라면
                    adj[from].add(to); // 인접 리스트에 간선 정보 추가
                }
            }

            bw.write(String.format("#%d %d\n", t, solution())); // 정답 버퍼 저장
        }

        bw.close(); // 정답 버퍼 출력
    }
}
