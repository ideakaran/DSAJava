import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//227. Basic Calculator II
public class BasicCalculator2 {
    Map<String, ArrayList<Integer>> operatorToIndex;

    public BasicCalculator2(){

    }
    public int calculate(String s) {
        String original = s;
        clearOperators();
        updateOperators(original);
        for (String keys : operatorToIndex.keySet()) {
            ArrayList index = (ArrayList)operatorToIndex.get(keys);
            if(index.size() > 0) {
                int opIndex = (int) index.get(0);
                String result = performOperation(original.charAt(opIndex - 1) - '0', String.valueOf(keys), original.charAt(opIndex + 1) - '0');
                original = original.replace(original.substring(opIndex - 1, opIndex + 2), result);
                clearOperators();
                updateOperators(original);
            }
        }
        return Integer.parseInt(original);
    }

    void updateOperators(String s) {
        for(int i =0; i< s.length(); i++) {
            char character = s.charAt(i);
            setOperators(character, i);
        }
    }


    void clearOperators() {
        this.operatorToIndex = new HashMap<>();
        this.operatorToIndex.put("*", new ArrayList<>());
        this.operatorToIndex.put("/", new ArrayList<>());
        this.operatorToIndex.put("+", new ArrayList<>());
        this.operatorToIndex.put("-", new ArrayList<>());
    }

    public void setOperators(char character, int index){


        switch (character) {
            case('*'):
            case('/'):
            case('+'):
            case('-'): {
                ArrayList list = this.operatorToIndex.get(String.valueOf(character));
                list.add(index);
                break;
            }
        }
    }


    private String performOperation(int leftVal, String operator, int rightVal) {
        String result = "";
        switch (operator) {
            case("*"): {
                result = String.valueOf(leftVal * rightVal);
                break;
            }
            case("/"): {
                result = String.valueOf(leftVal / rightVal);
                break;
            }
            case("+"): {
                result = String.valueOf(leftVal + rightVal);
                break;
            }
            case("-"): {
                result = String.valueOf(leftVal - rightVal);
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        BasicCalculator2 bc = new BasicCalculator2();
        int val = bc.calculate("3+2*2/2");
        System.out.println("val = " + val);
    }
}
