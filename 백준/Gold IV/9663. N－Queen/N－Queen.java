import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int ans;
    public static int N;

    public static int [] queens;
    public static int sizeDiag;
    public static int [] diag1;
    public static int [] diag2;

    public static void solution(int row) {
        if(row == N) {
            ans++;
        } else {
            for(int col = 0; col < N; col++){
                if(queens[col] == 0 && diag1[(row-col)+(N-1)] == 0 && diag2[row+col] == 0) {
                    queens[col] = 1;
                    diag1[(row-col)+(N-1)] = 1;
                    diag2[row+col] = 1;

                    solution(row + 1);

                    queens[col] = 0;
                    diag1[(row-col)+(N-1)] = 0;
                    diag2[row+col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        queens = new int[N];
        sizeDiag = 2 * N - 1;
        diag1 = new int[sizeDiag];
        diag2 = new int[sizeDiag];

        solution(0);

        System.out.println(ans);
    }
}
