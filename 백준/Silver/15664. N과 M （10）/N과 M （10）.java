import java.util.*;

public class Main {

    public static int N, M;
    public static List<Integer> li = new ArrayList<>();
    public static List<int[]> results = new ArrayList<>();

    public static boolean has (int [] arr) {

        for(int [] comp : results) {
            if (Arrays.equals(comp, arr)) {
                return true;
            }
        }

        return false;
    }

    public static void bt(int idx, int cnt, int [] seq) {
        if (cnt < M) {
            for(int i = idx + 1; i < N; i++){
                int [] newSeq = Arrays.copyOf(seq, cnt+1);
                newSeq[cnt] = li.get(i);

                bt(i, cnt + 1, newSeq);
            }
        } else {
            if(!has(seq)){
                String ans = "";
                for(int i = 0; i < seq.length; i++) {
                    ans += seq[i];
                    if (i != seq.length-1){
                        ans += " ";
                    }
                }
                System.out.println(ans);

                results.add(seq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i < N; i++){
            li.add(sc.nextInt());
        }

        li.sort(Comparator.naturalOrder());

        for(int i = 0; i <= N - M; i++){
            int [] arr = new int[M];
            arr[0] = li.get(i);

            bt(i, 1, arr);
        }
    }
}
