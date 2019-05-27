import java.util.Scanner;

public class Main {

    private Message mes;
    private static String username;
    private static Scanner Insert = new Scanner(System.in);
    private static boolean flag = true;

    public static void main(String[] args) {

        Network net = Network.getInstance();

        User u1 = new User("egw", "akkaka@gmail.com");
        User u2 = new User("esu", "alala@hotmail.gr");
        User u3 = new User("kapoios","dada@okp.gr");
        User u5 = new User( "allos","dalda@kpo.com");
        User u6 = new User("enas", "djalda@ofka.com");

        net.addUser(u1);
        net.addUser(u2);
        net.addUser(u3);
        net.addUser(u5);
        net.addUser(u6);

        u1.setFriends(u2);
        u3.setFriends(u1);
        u3.setMessage(u3,"geia");
        u2.setMessage(u3,"sou");
        u1.setMessage(u3,"ti");
        u5.setMessage(u3,"kaneis");
        u2.Like(u3.getMessages().get(2));
        u5.Like(u3.getMessages().get(2));
        u1.setMessage(u2,"egw eimai pali");
        u2.setMessage(u2,"edw eimaiii");

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
