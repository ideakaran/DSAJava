package oldpractice;

import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        int num1Length = num1.length();
        int num2Length = num2.length();
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length - 1; j >= 0; j--) {
                int val1 = num1.charAt(i) - '0';
                int val2 = num2.charAt(j) - '0';
                int mul = val1 * val2;
                mul += result[i + j + 1];
                result[i + j + 1] = mul % 10;
                result[i + j] += mul / 10;

//                int product = val1 * val2;
//                product += result[i + j + 1];
//                result[i + j + 1] = product % 10;
//                result[i + j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if(sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        System.out.println(sb);

    }
}
