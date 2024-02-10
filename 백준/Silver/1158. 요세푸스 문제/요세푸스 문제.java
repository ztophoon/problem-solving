import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static List<Integer> li = new LinkedList<>(); // 요세푸스 순열을 저장할 리스트

    public static StringTokenizer st; // 문자열을 토큰화하기 위한 StringTokenizer
    public static StringBuilder sb = new StringBuilder(); // 결과 문자열을 저장할 StringBuilder
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력을 받기 위한 버퍼리더
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 버퍼라이터

    public static void solution() {
        for (int i = 1; i <= N; i++) { 
            li.add(i); // 1부터 N까지의 숫자를 리스트에 추가
        }

        int idx = 0; // 요세푸스 순열에서 제거할 사람의 인덱스
        while (!li.isEmpty()) { // 리스트가 비어있지 않을 때까지
            idx = (idx + (K - 1)) % li.size(); // 현재 인덱스에 K를 더한 후 리스트의 크기로 나눈 나머지를 새로운 인덱스로 설정
            sb.append(li.remove(idx)); // 해당 인덱스의 값을 제거하고 결과 문자열에 추가
            if (!li.isEmpty()) { // 리스트가 비어있지 않으면,
                sb.append(", "); // 쉼표와 공백 추가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수 입력
        K = Integer.parseInt(st.nextToken()); // K 입력

        sb.append("<"); // 결과 문자열에 < 추가
        solution();     // 요세푸스 순열 계산 메서드 호출
        sb.append(">"); // 결과 문자열에 > 추가

        bw.write(sb.toString()); // 결과 문자열 출력
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 버퍼 닫기
    }
}
