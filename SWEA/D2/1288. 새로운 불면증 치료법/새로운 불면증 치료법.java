import java.util.Scanner;

public class Solution {

    public static int solution(int N){
        int cnt = 1;
        int mask = 0;

        while(true) {
            String stringN = "" + ((cnt++) * N);
            for(char C : stringN.toCharArray()){
                mask |= 1 << ((int)C - '0');
            }

            if(mask == (1 << 10) - 1) {
                break;
            }
        }

        return (cnt-1) * N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int N;
        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            System.out.printf("#%d %d\n", t, solution(N));
        }
    }
}
