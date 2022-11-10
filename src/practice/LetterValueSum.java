package practice;

public class LetterValueSum {
    public static void main(String[] args) {
        String input = "abc";
        int sum = 0;
        if(input == null || input.isEmpty()) {
            return;
        }
        for(char c : input.toCharArray()) {
            sum += c - 'a' + 1;
        }
        System.out.println("sum = " + sum);
    }
}
