import java.util.Scanner;
class Menu {

    private User user;
    private int exit = 0;
    Menu() {
    }

    int Run(String username, String email, Network net){
        Scanner Insert = new Scanner(System.in);
        for (User u : net.getUsers()){
            if (username.equals(u.getUser())){ this.user = u; }
        }
        while (exit == 0)
        {

            System.out.println("-----What would you like to do? (Enter a number)-----");
            System.out.println("\t[1]See your Wall\n\t[2]See friend's Wall\n\t[3]Send Friend Request\n\t[4]Answer to Friend Request\n\t[5]See my friends\n\t[6]Log out\n\t[7]Exit");
            int option = Insert.nextInt();
            switch (option)
            {
                case 1:
                    user.getWall();
                    break;

                case 2:
                    System.out.println("-----Whose wall would you like to visit?(Enter a number)-----");
                    user.showFriends();
                    System.out.println("-----Back [" + user.getFriends().size() + "]-----");
                    option = Insert.nextInt();
                    if (option < user.getFriends().size() && option >= 0)
                        user.getFriends().get(option).getWall();
                    else if (option == user.getFriends().size())
                        break;

                    System.out.println("\t[1]Post a message\n\t[2]Reply to a message\n\t[3]Like a Message\n\t[4]Back");
                    int choice;
                    choice = Insert.nextInt();

                    while (choice <1 || choice>4)
                    {
                        System.out.println("Please Enter a valid number. (From 1 to 4)");
                        choice = Insert.nextInt();
                    }

                    switch (choice)
                    {
                        case 1:
                            user.PostMess(user.getFriends().get(option));
                            break;

                        case 2:
                            System.out.println("-----Select Message to Reply to? (Enter a number)-----");
                            user.getFriends().get(option).ShowMessages();
                            System.out.println("-----Back [" + user.getFriends().get(option).getMessages().size() + "]-----");
                            choice = Insert.nextInt();
                            if ( choice >= 0 && choice < user.getFriends().get(option).getMessages().size() )
                                user.setReply(user.getFriends().get(option).getMessages().get(choice));
                            break;

                        case 3:
                            System.out.println("-----Select a message to 'Like'? (Enter a number)-----");
                            user.getFriends().get(option).ShowMessages();
                            System.out.println("-----Back [" + user.getFriends().get(option).getMessages().size() + "]-----");
                            choice = Insert.nextInt();
                            if ( choice >= 0 && choice < user.getFriends().get(option).getMessages().size() )
                                user.Like(user.getFriends().get(option).getMessages().get(choice));
                            break;
                        case 4:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("-----Select someone to send a Friend Request to? (Enter a number)-----");
                    user.addNotFriends();
                    user.showNotFriends();
                    option = Insert.nextInt();
                    user.friendship(user.getNotFriends().get(option),(short)0);
                    break;

                case 4:
                    System.out.println("-----Select someone to respond to their Friend Request? (Enter a number)-----");
                    user.ShowAitimata();
                    System.out.println("-----Back [" + user.getAitimataAutoi().size() + "]-----");
                    option = Insert.nextInt();

                    if ( option >= 0 && option < user.getAitimataAutoi().size() )
                        user.AnswerR(user.getAitimataAutoi().get(option));
                    break;

                case 5:
                    user.showFriends();
                    break;

                case 6:
                    exit = 1;
                    System.out.println("------You have successfully logged out of Fakebook------");
                    break;

                case 7:
                    exit = 2;
                    System.out.println("-----Goodbye :) ------");
                    break;

                default:
                    System.out.println("Please Enter a valid number. (From 1 to 8)");
            }
        }
        return exit;
    }
}