import java.util.*;
public class Network {
    private static Network net = null;
    private ArrayList<User> ListofUsers;
    private boolean F = false;
    private ArrayList<User> UserdH;

    private Network() {
        this.ListofUsers = new ArrayList<>();
        this.UserdH = new ArrayList<>();
    }

    static Network getInstance() {
        if (net == null)
            net = new Network();

        return net;
    }
    // Epistrefei Tin lista me tous Users pou diathetei to Network
    ArrayList<User> getUsers() {
        return ListofUsers;
    }

    // Pairnei san orisma enan xristi kai epistrefei mia lista stin opoia exei olous tous xristes pou den exeis filous.
    ArrayList<User> getUsersYDhave(User u) {
        this.UserdH.clear();
        for (User m : ListofUsers) {
            if (!(u.getFriends().contains(m) || u.getUser().equals(m.getUser()) || u.getAitimataEgw().contains(m))) {
                this.UserdH.add(m);
            }
        }
        return UserdH;
    }

    //prosthiki enos user sto Network
    void addUser(User Nuser) {
        if (ListofUsers.contains(Nuser))
            System.out.println("Yparxei idi sto systima");
        else ListofUsers.add(Nuser);
    }

    //diagrafh User apo to Network
    public void delUser(User rUser) {
        if (ListofUsers.contains(rUser))
            ListofUsers.remove(rUser);
        else System.out.println("Den uparxei sto systima");
    }


    // Tsekarei ean duo xristes einai idi filoi i ean milame gia ton idio xristi 2 fores.
    private boolean AreFriends(User user1, User user2) {
        if (!(user1.getUser().equals(user2.getUser()))) {
            if (user1.getFriends().contains(user2)) {
                F = true;
            }
        }
        return F;
    }

    boolean connect(User user1, User user2) {
        return (!(user1.getUser().equals(user2.getUser())) && !this.AreFriends(user1, user2));
    }
    // Pairname san orismata duo xristes kai epistrefoume tous koinous tous filous se mia lista.
    ArrayList<User> getMutuals(User user1, User user2) {
        ArrayList<User> Mutuals = new ArrayList<>();
        for (User i : user1.getFriends()) {
            for (User j : user2.getFriends()) {
                if (i == j) {
                    Mutuals.add(i);
                }
            }
        }
        return (Mutuals);
    }
    // Helper Method , h opoia dimiourgei xristes , posts ,likes , filies , me thn enarksi tou programmatos.
    public void HelperMethod() {

        User u1 = new User("George", "akkaka@gmail.com");
        User u2 = new User("Constantine", "alala@hotmail.gr");
        User u3 = new User("Meletis", "dada@okp.gr");
        User u4 = new User("Toby", "toby@gmail.com");
        User u5 = new User("Dwight", "dalda@kpo.com");
        User u6 = new User("Jim", "djalda@ofka.com");
        User u7 = new User("Melina", "melina@ofka.com");
        User u8 = new User("Aggeliki", "aggeliki@ofka.com");


        net.addUser(u1);
        net.addUser(u2);
        net.addUser(u3);
        net.addUser(u5);
        net.addUser(u6);
        net.addUser(u7);
        net.addUser(u8);

        u2.setFriends(u3);
        u1.setFriends(u2);
        u1.setFriends(u3);
        u1.setFriends(u4);
        u3.setFriends(u1);
        u3.setFriends(u6);
        u3.setFriends(u8);
        u5.setFriends(u1);
        u5.setFriends(u2);
        u5.setFriends(u7);
        u4.setFriends(u3);
        u2.setFriends(u1);
        u3.setMessage(u3, "Goodmorning everybody :) :) ");
        u1.setMessage(u3, "Hey Meletis , don't forget about tonight! ");
        u4.setMessage(u3, "Hey buddy!!! ");
        u2.setMessage(u1, "Yo Yo , check the new album of Tyler , its dope! ");
        u1.setMessage(u4, "Call me ASAP , we have a serious problem ! ");
        u2.Like(u3.getMessages().get(2));
        u5.Like(u3.getMessages().get(2));
        u1.setMessage(u2, "Hey , how about dinner tonight? :D :D ");
        u5.setMessage(u1,"Say my Name");
        u5.setMessage(u2,"Los Pollos Hermanos");
        u5.setMessage(u7, "How you doing");
        u2.setMessage(u3,"HEEEY");

}}