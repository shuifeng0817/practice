public class Switch {
    public static void main(String[] args) {
        int number = 1;
        switch (number) {
            case 1 -> {
                System.out.println("一");
            }
            case 2 -> {
                System.out.println("二");
            }
            default -> {
                System.out.println("无");
            }
        }
    }
}
