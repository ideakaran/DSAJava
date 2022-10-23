public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int integerValue = 0;
        int val = 0;
        for(int i=0; i < s.length(); i++) {
            val += getIXCValue(i, s);
        }
        return val;
    }

    public int getIXCValue(int index, String input) {
        String val = String.valueOf(input.charAt(index));
        int lengthOfInput = input.length();
        String leftVal = "";
        if(lengthOfInput >= 2) {
            leftVal = String.valueOf(input.charAt(index - 1));
        }
        int finalVal = 0;

        switch(val) {
            case "I":
                finalVal = 1;
                break;

            case "V":
                if(leftVal.equalsIgnoreCase("I")) {
                    finalVal = 3;
                } else {
                    finalVal = 5;
                }
                break;

            case "X":
                if(leftVal.equalsIgnoreCase("I")) {
                    finalVal = 8;
                } else {
                    finalVal = 10;
                }
                break;

            case "L":
                if(leftVal.equalsIgnoreCase("X")) {
                    finalVal = 30;
                } else {
                    finalVal = 50;
                }
                break;
            case "C":
                if(leftVal.equalsIgnoreCase("X")) {
                    finalVal = 80;
                } else {
                    finalVal = 100;
                }
                break;


            case "D":
                if(leftVal.equalsIgnoreCase("C")) {
                    finalVal = 300;
                } else {
                    finalVal = 500;
                }
                break;

            case "M":
                if(leftVal.equalsIgnoreCase("C")) {
                    finalVal = 800;
                } else {
                    finalVal = 1000;
                }
                break;


            default:
                break;

        }
        return finalVal;
    }
}
