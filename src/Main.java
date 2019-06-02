import java.util.Scanner;

public class Main {

    private Message mes;
    private static String username;
    private static Scanner Insert = new Scanner(System.in);
    private static boolean flag = true;

    public static void main(String[] args) {

        Network net = Network.getInstance();
        net.HelperMethod();

        int i;
        do {
            while (flag) {
                System.out.println("Enter your username:\n");
                username = Insert.nextLine();
                for (User u : net.getUsers()) {
                    if (u.getUser().equals(username)) {
                        flag = false;
                    }
                }
            }

            System.out.println("-----Welcome To Fakebook User: " + username + " -----");
            Menu m1 = new Menu();
            i = m1.Run(username, "dada@okp.gr", net);
            if ( i == 2) break;
            if ( i == 1) flag = true;
        } while (i==1);
    }
}
