package oldpractice;

public class HelloGoodbye {
    public static void main(String[] args) {
        StringBuilder hello = new StringBuilder("Hello ").append(args[0]).append(" and ").append(args[1]);
        StringBuilder goodbye = new StringBuilder("Goodbye ").append(args[1]).append(" and ").append(args[0]);
        System.out.println(hello);
        System.out.println(goodbye);
    }
}
