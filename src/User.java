import java.util.*;
import java.util.Scanner;

public class User
{

    private String username;
    private String email;
    private ArrayList<User> friends;
    private String post;
    private ArrayList<Message> messages;
    private Scanner Insert = new Scanner(System.in);
    private ArrayList<User> aitimataEgw;
    private ArrayList<User> aitimataAutoi;
    private ArrayList<User> NotFriends;
    private ArrayList<FriendRequest> FriendReqs;
    static private Network net = Network.getInstance();

    User(String username, String email)    {
        this.username = username;
        this.email = email;
        this.NotFriends = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.aitimataEgw = new ArrayList<>();
        this.aitimataAutoi = new ArrayList<>();
        this.FriendReqs = new ArrayList<>();
        net.addUser(this);
    }
    // method gia na kanoume collect tous Mi - filous apo to network.
    void addNotFriends(){NotFriends =  net.getUsersYDhave(this);}
    ArrayList<User> getNotFriends(){return NotFriends;}

    //Methodo gia na ektupwsoume olous tous MI - filous.
    void showNotFriends(){
        for (int i=0 ; i<NotFriends.size() ;i++ ){
            System.out.println( "["+i+"]: "+NotFriends.get(i).getUser() );
        }
    }
    // Setter gia to username tou User.
    public void setUser(String user){username = user ;}
    // Setter gia to email tou User.
    public void setEmail(String em){email = em ;}
    // getter gia to Username tou User.
    String getUser(){return username;}
    // getter gia to Email tou User.
    public String getEmail(){return email;}
    // Epistrefei ola ta aitimata filias pou exoun kanei ston User.
    ArrayList<User> getAitimataAutoi(){return this.aitimataAutoi;}
    // Epistrefei ola ta aitimata filias pou exei pragmatopoihsei o User se allous.
    ArrayList<User> getAitimataEgw() {return this.aitimataEgw;}
    // Ektupwnei ta Aitimata pou exoun kanei ston User.
    void ShowAitimata(){
        for (int i=0 ; i< aitimataAutoi.size(); i++){
            System.out.println(i+ ": " + aitimataAutoi.get(i));
        }
    }

    //xeirizetai aithmata filias (add && remove)
    void friendship(User user1, short epilogh) {
        switch (epilogh) {
            case 0:
                if (this.friends.contains(user1)) {
                    System.out.println("Already friends.");
                } else {
                    this.aitimataEgw.add(user1);
                    user1.aitimataAutoi.add(this);

                    System.out.println("User " + user1.getUser() + " was added.");

                    FriendRequest fr = new FriendRequest(this, user1);

                    this.FriendReqs.add(fr);
                    user1.FriendReqs.add(fr);
                }
            case 1:
                if (this.friends.contains(user1)) {
                    this.friends.remove(user1);
                    user1.friends.remove(this);
                    System.out.println("User " + user1.getUser() + " was removed.");
                }
        }
    }

    //emfanizei ton toixo tou
    void getWall () {
        Wall wall = new Wall(this);
        wall.DisplayPosts();
    }

    //getting the FriendRequest list of a User
    public ArrayList<FriendRequest> getFriendRequest(){
        return this.FriendReqs;
    }

    //Apodoxh/Aporripsh filias
    void AnswerR(User AFriend){
        System.out.println("Would you like " + AFriend.getUser() + " to be your friend? \n");
        char ch;
        do {
            System.out.println("Enter 'Y' to accept, 'N' to decline, 'O' to exit.\n");
            ch = Insert.next().charAt(0);
        }
        while ( ch != 'Y' && ch != 'N' && ch != 'O' );

        if (ch =='Y' && net.connect(this,AFriend)) {
            this.friends.add(AFriend);
            AFriend.friends.add(this);
            for (FriendRequest i : this.FriendReqs) {
                if ( i.getReceived().equals(this) ){
                    i.setStatusE(FriendRequest.Status.Accepted);
                }
            }
            for (FriendRequest i : AFriend.FriendReqs) {
                if ( i.getSent().equals(AFriend) ){
                    i.setStatusE(FriendRequest.Status.Accepted);
                }
            }
        }
        else if(ch == 'N' && net.connect(this,AFriend)){
            for (FriendRequest i : this.FriendReqs) {
                if ( i.getReceived().equals(this) ){
                    i.setStatusE(FriendRequest.Status.Rejected);
                }
            }
            for (FriendRequest i : AFriend.FriendReqs) {
                if ( i.getSent().equals(AFriend) ){
                    i.setStatusE(FriendRequest.Status.Rejected);
                }
            }

        }


    }

    //Postarei message se wall
    void PostMess(User u){
        if ( u.getUser().equals(this.username) || u.getFriends().contains(this)){
            System.out.println("What would you like to post?\n");
            post = Insert.nextLine();
            Message mes = new Message(post, this);
            u.messages.add(mes);
        }
    }



    //Kanei like se message
    void Like(Message m){m.setLike(this) ;}

    //Kanei like se reply
    public void Like(ReplyMessage rm) {rm.setLike(this);}

    //epistrefei tous filous
    ArrayList<User> getFriends(){
        return this.friends;
    }

    //epistrefei tous koinous filous
    public ArrayList<User> getMutual(User u2){
        return net.getMutuals(this, u2);
    }

    //emfanish filwn
    void showFriends(){
        System.out.println("-----Your friends are:-----");
        for (int i=0 ; i < friends.size(); i++){
            System.out.println(i + ": " + friends.get(i).getUser());
        }
    }

    //emfanizontai ta posts
    ArrayList<Message> getMessages(){return this.messages;}

    //Ektupwnontai ta posts
    void ShowMessages(){
        for (int i=0;i<messages.size(); i++ )
        {System.out.println("\n" + i+ ": "+ messages.get(i));}

    }

    //postarei comment se post
    void setReply(Message m)
    {
        System.out.println("Add your comment:");
        post = Insert.nextLine();
        ReplyMessage re = new ReplyMessage(post,this) ;
        m.addreply(re);
    }

    //emfanizontai ta FriendRequests tou xrhsth
    public void getFriendRequests()
    {
        if ( this.FriendReqs != null) {
            for (FriendRequest i : this.FriendReqs) {
                if ( i.getSent().equals(this))
                    System.out.println("The User: " + i.getSent().getUser() + " sent a request at: " + i.getTime() +
                            " and User: " + i.getReceived().getUser() + "\tStatus: " + i.getStatus());
                else System.out.println("The User: " + i.getReceived().getUser() + " received a request at: " + i.getTime() +
                        " from User: " + i.getSent().getUser() + "\tStatus: " + i.getStatus());
            }
        }
        else {
            System.out.println("The User : " + this.getUser() + " doesn't have any requests! \n");
        }
    }
    // Epistrefei Username , email tou User.
    public String toString(){
        return ("Username: "+username+"\te-mail: "+email);
    }

    //-------------helpers----------------- tous opoious tous xrisimopoioume stin Class Network.
    void Reply(Message mes, String a)
    {
        ReplyMessage rm = new ReplyMessage(a,this);
        mes.addreply(rm);
    }

    void setMessage(User u, String post)
    {
        Message mes = new Message(post, this);
        u.messages.add(mes);
    }

    void setFriends(User u2)
    {
        this.friends.add(u2);
        u2.friends.add(this);
    }


}
