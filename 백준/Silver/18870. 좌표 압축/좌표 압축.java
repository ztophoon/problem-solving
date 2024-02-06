import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int [] inp;

    public static Set<Integer> s = new HashSet<>();
    public static Map<Integer, Integer> hash = new HashMap<>();
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        inp = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());
            inp[i] = num;
            s.add(num);
        }

        pq.addAll(s);
        
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            hash.put(pq.poll(), i);
        }

        for(int n : inp){
            bw.write(hash.get(n) + " ");
        }

        bw.flush();
        bw.close();
    }

}
