import java.io.*;
import java.util.*;

/*
 * combination을 통해 암호에 추가할 모음을 1개 부터 L-2개 까지 선택,
 * 마찬가지로 추가한 모음의 개수에 따라 나머지 개수의 자음을 선택
 * 재귀를 통해 해당 탐색 시 선택되어있는 모음, 자음을 사전순으로 정렬하여 암호 누적
 * 누적된 암호문을 다시 사전 순으로 정렬해서 출력
 */

public class Main {

    public static int L, C; // 암호문의 길이, 알파벳의 개수

    public static int jaIdx, moIdx; // 자음 배열 인덱스, 모음 배열 인덱스
    public static char [] ja, mo;   // 자음 저장 배열, 모음 저장 배열
    public static int [] nowJa, nowMo; // 해당 탐색 시 선택된 자음과 모음

    public static ArrayList<String> passwords = new ArrayList<>(); // 최종 생성된 암호문 저장 리스트

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void password(){
        sb = new StringBuilder(); // 암호문 생성을 위한 string builder 초기화

        for(int i = 0; i < jaIdx; i++){
            if(nowJa[i] == 1){    // 현재 선택된 자음들에 대해,
                sb.append(ja[i]); // 암호문에 추가
            }
        }

        for(int i = 0; i < moIdx; i++){
            if(nowMo[i] == 1){   // 현재 선택된 모음들에 대해,
               sb.append(mo[i]); // 암호문에 추가
            }
        }

        char [] pw = sb.toString().toCharArray(); // 만들어진 암호문을 정렬을 위해 char 배열로 변환
        Arrays.sort(pw); // 사전순 정렬

        passwords.add(String.valueOf(pw)); // 사전순으로 정렬된 암호문을 다시 String으로 변환후 리스트에 저장
    }

    public static void getJa(int jaCnt, int cnt, int idx){
        if(cnt == jaCnt){ // 선택하려는 자음의 개수 만큼 자음을 선택했으면,
            password(); // 암호문 제작 시작
            return; // 재귀 종료
        }

        for(int i = idx + 1; i < jaIdx; i++){ // 자음 배열에 대해
            nowJa[i] = 1; // 이번 탐색에서 선택된 자음 표시
            getJa(jaCnt, cnt + 1, i); // 목표 개수만큼 자음을 선택할 때 까지 재귀
            nowJa[i] = 0; // 탐색된 자음 자음 선택 해제
        }
    }

    public static void getMo(int moCnt, int cnt, int idx){
        if(cnt == moCnt){ // 선택하려는 모음의 개수 만큼 모음을 선택했으면,
            getJa(L - moCnt, 0, -1); // 나머지 개수 만큼 자음 combination 시작
            return; // 재귀 종료
        }

        for(int i = idx + 1; i < moIdx; i++){ // 모음 배열에 대해
            nowMo[i] = 1; // 이번 탐색에서 선택된 모음 표시
            getMo(moCnt, cnt + 1, i); // 목표 개수만큼 모음을 선택할 때 까지 재귀
            nowMo[i] = 0; // 탐색된 모음 선택 해제
        }
    }

    public static void solution() throws IOException {
        for(int moCnt = 1; moCnt <= L - 2; moCnt++){ // 모음이 1개 이상, 자음이 2개  이상 필요하므로, 모음의 개수는 1개 ~ L-2개 가능 
            getMo(moCnt, 0, -1); // 모음 combination 시작
        }

        Collections.sort(passwords); // 저장된 암호문 정렬

        sb = new StringBuilder();
        for(String pw : passwords){  // 정렬된 암호문에 대해, 
            sb.append(pw).append("\n"); // 문자열 생성
        }

        bw.write(sb.toString()); // 버퍼 추가
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 암호문의 길이 입력
        C = Integer.parseInt(st.nextToken()); // 알파벳의 개수 입력

        ja = new char [C]; // 자음 저장 배열 초기화
        mo = new char [C]; // 모음 저장 배열 초기화

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            String c = st.nextToken(); // 문자열 입력

            if("aeiou".contains(c)){ // 입력이 모음인 경우,
                mo[moIdx++] = c.toCharArray()[0]; // 모음 배열에 추가
            } else { // 입력이 모음이 아닌 경우, 즉 자음인 경우
                ja[jaIdx++] = c.toCharArray()[0]; // 자음 배열에 추가
            }
        }

        nowJa = new int[jaIdx]; // 선택된 자음 표시 배열 초기화
        nowMo = new int[moIdx]; // 선택된 모음 표시 배열 초기화
        
        solution(); // 풀이 시작
        bw.close(); // 버퍼 출력
    }
}
