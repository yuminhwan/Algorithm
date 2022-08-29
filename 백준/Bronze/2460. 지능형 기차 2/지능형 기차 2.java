import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int person = 0;
        int max = -1;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int outPerson = Integer.parseInt(st.nextToken());
            int inPerson = Integer.parseInt(st.nextToken());
            person += (inPerson - outPerson);

            if (person > max) {
                max = person;
            }
        }

        System.out.println(max);
    }
}

