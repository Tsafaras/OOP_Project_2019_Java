import java.util.*;
public class Network
{
    private static Network net = null;
    private ArrayList<User>ListofUsers;
    private boolean F = false;
    private ArrayList<User>UserdH;
    private Network(){
        this.ListofUsers = new ArrayList<>();
        this.UserdH = new ArrayList<>();
    }
    static Network getInstance(){
        if (net == null)
            net = new Network();

        return net;
    }

    ArrayList<User> getUsers(){ return ListofUsers;}

    //Leitourgikothta 3.
    ArrayList<User> getUsersYDhave(User u ){
        this.UserdH.clear();
        for ( User m : ListofUsers){
            if (!(u.getFriends().contains(m) || u.getUser().equals(m.getUser()) || u.getAitimataEgw().contains(m) )) {
                this.UserdH.add(m);
            }
        }
        return UserdH;
    }

    //pros8hkh User sto Network
    void addUser(User Nuser){
        if (ListofUsers.contains(Nuser))
            System.out.println("Yparxei idi sto systima");
        else ListofUsers.add(Nuser);
    }

    //diagrafh User apo to Network
    public void delUser(User rUser){
        if(ListofUsers.contains(rUser))
            ListofUsers.remove(rUser);
        else System.out.println("Den uparxei sto systima");
    }

    /*public boolean RFriendship(User user1, User user2){
        if ( user1.getUser() != user2.getUser() ){
            System.out.println("mphke");
            ArrayList<User> friendsCopy = new ArrayList<User>();
            friendsCopy = user1.getFriendscpy();
            if(friendsCopy.contains(user2)){ F = true ; }
        }
        return F;
    }*/

    private boolean AreFriends(User user1, User user2){
        if ( !(user1.getUser().equals(user2.getUser())) ) {
            if(user1.getFriends().contains(user2)){ F = true; }
        }
        return F;
    }

    boolean connect(User user1, User user2){
        return ( !(user1.getUser().equals(user2.getUser())) && !this.AreFriends(user1, user2));
    }

    ArrayList<User> getMutuals(User user1,User user2){
        ArrayList<User> Mutuals = new ArrayList<>();
        for ( User i : user1.getFriends() ) {
            for (User j : user2.getFriends() ) {
                if ( i == j ) { Mutuals.add(i); }
            }
        }
        return (Mutuals);
    }
}
