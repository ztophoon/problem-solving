import java.io.*;
import java.util.*;

/*
 * 강의의 시작 시간, 종료 시간을 각각 minHeap으로 정렬
 * 오름차순으로 정렬된 시작 시간들을 차례로 순회하면서, 종료 시간들의 최소 값과 비교
 *
 * 1. 조회된 시작 시간이 조회 시점에서 종료 시간들의 최소값 보다 크다면, 그 최소값 뒤에 바로 이에 붙여서 강의실을 연속으로 사용 가능
 * 2. 조회된 시작 시간이 조회 시점에서 종료 시간들의 최소값 보다 작다면, 강의를 뒤에 이어 붙일 수 있는 강의실이 없다는 것이므로 강의실 개수 추가
 *
 * 시작 시간과 종료 시간을 모두 오름차순으로 정렬해두었으므로 조회 시점 당시 만을 고려하여 가능한 경우의 수를 만들어간다 -> greedy
 */

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N, answer;

    public static PriorityQueue<Integer> startTimesPQ = new PriorityQueue<>(); // 강의 시작 시간 minHeap
    public static PriorityQueue<Integer> termiTimesPQ = new PriorityQueue<>(); // 강의 종료 시간 minHeap

    public static void solution() {
        while(!startTimesPQ.isEmpty()){      // 오름차순으로 정렬된 heap을 순회하면서,
            int start = startTimesPQ.poll(); // 강의 시작 시간 조회

            if(!termiTimesPQ.isEmpty() && termiTimesPQ.peek() <= start){ // 조회된 시작 시간이 종료 시간들 중 최소값보다 작다면, 강의실을 연속으로 사용 가능!
                termiTimesPQ.poll();                                     // 이때 종료 시간은 더 이상 최소 종료 시간이 아니므로 heap에서 삭제
            } else {                                                     // 시작 시간이 종료 시간 중 최소값 보다 크다면, 반드시 새로운 강의실이 필요
                answer++;                                                // 강의실 개수 추가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            startTimesPQ.offer(s);
            termiTimesPQ.offer(t);
        }

        solution();

        bw.write(Integer.toString(answer));
        bw.close();
    }
}
