/**
 * @author jleo
 * @date 2021/4/14
 */
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n - 2];
        for (int i = 0; i < n - 2; i++) {
            String s = in.next();
            if (s.equals("A") || s.equals("B")) {
                i--;
            } else {
                strings[i] = s;
            }
        }
        int count = 1;
        List<String> array = new ArrayList<>();
        array.add("AB");
        for (int i = 2; i < n; i++) {
            count *= (i + 1);
            List<String> array2 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (String arr : array) {
                    String s = arr.substring(0, j) + strings[i - 2] + arr.substring(j, i);
                    array2.add(s);
                }
            }
            array = array2;
        }
        for (int i = 0; i < count; i++) {
            String[] str = array.get(i).split("");
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[j]);
                if (j == str.length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }
        }
        System.out.println(count);
    }
}
