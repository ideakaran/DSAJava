import java.util.HashMap;
import java.util.Map;

public class LetterValueSum {
    public static void main(String[] args) {
        String input = "karan";
        int sum = 0;
        if(input == null || input.isEmpty()) {
           return;
        }
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        hashMap.put("d", 4);
        hashMap.put("e", 5);
        hashMap.put("f", 6);
        hashMap.put("g", 7);
        hashMap.put("h", 8);
        hashMap.put("i", 9);
        hashMap.put("j", 10);
        hashMap.put("k", 11);
        hashMap.put("l", 12);
        hashMap.put("m", 13);
        hashMap.put("n", 14);
        hashMap.put("r", 18);


        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            sum += hashMap.get(currentChar);
        }
        System.out.println("sum = " + sum);
    }
}
