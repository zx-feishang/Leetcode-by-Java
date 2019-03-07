package leetcode;

import java.util.*;

public class KDXF2019_killer {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        int count = 0;
        while (list.size() > 1) {
            for (int i = list.size() - 1; i >= 1; i--) {
                if (list.get(i) < list.get(i - 1)) {
                    list.remove(i);
                }
            }
            if (list.size() == n) {
                break;
            } else {
                n = list.size();
                count++;
            }
        }
        System.out.println(count);

    }

}
