import java.io.*;
import java.util.*;

public class Main {

    public static int N;      // 카드 개수
    public static int answer; // 정답 카드

    public static Queue<Integer> q = new ArrayDeque<>(); // 카드 저장 큐

    public static BufferedReader br;  // 입력을 받기 위한 버퍼리더
    public static BufferedWriter bw;  // 결과를 출력하기 위한 버퍼라이터
    public static StringTokenizer st; // 문자열을 토큰화하기 위한 StringTokenizer

    public static void solution() throws Exception {
        for (int i = 1; i <= N; i++) {
            q.offer(i); // 큐에 1부터 N까지의 수를 추가
        }

        int n;
        while (q.size() > 1) { // 카드가 1개가 될 때 까지 반복
            q.poll();          // 카드 버리기 : 큐에서 하나를 제거
            q.offer(q.poll()); // 카드 섞기 : 큐에서 pop한 카드를 다시 push
        }

        answer = q.poll(); // 마지막으로 남은 카드
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 버퍼리더
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 버퍼라이터

        N = Integer.parseInt(br.readLine()); // 카드 개수 입력

        solution();

        bw.write("" + answer); // 결과값 출력
        bw.newLine(); // 줄 바꿈
        bw.flush();   // 출력 버퍼 비우기
        bw.close();   // 출력 버퍼 닫기
    }
}
