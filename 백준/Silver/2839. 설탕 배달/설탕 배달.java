import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution(int N) throws IOException {
        int answer = -1;
        int numFive = N / 5;

        if(N == 3){
            answer = 1;
        } else if(numFive != 0){
            int num, numThree = 0;
            loop : while(numFive >= 0){
                do {
                    num = numFive * 5 + numThree * 3;
                    if (num == N) {
                        answer = numFive + numThree;
                        break loop;
                    }
                    numThree++;
                } while(num < N);
                numFive--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        bw.write(solution(Integer.parseInt(br.readLine())) + "");
        bw.close();
    }
}
