import java.util.Scanner;

public class TrafficLightSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter traffic light state (1 for Red, 2 for Yellow, 3 for Green): ");
        int state = sc.nextInt();

        switch (state) {
            case 1:
                System.out.println("Red Light : STOP");
                break;
            case 2:
                System.out.println("Yellow Light : SLOW DOWN");
                break;
            case 3:
                System.out.println("Green Light : GO");
                break;
            default:
                System.out.println("Invalid input! Please enter 1, 2, or 3.");
        }

        sc.close();
    }
}
