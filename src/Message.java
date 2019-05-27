import java.sql.Timestamp;
import java.util.*;
public class Message
{

    private String minima;
    private Timestamp time ;
    private int  likes;
    private String Username ;
    private ArrayList<ReplyMessage> ReMessa;
    private ArrayList<User> LikedBy;

    Message(String minima , Timestamp time ,User u1)
    {
        this.minima = minima ;
        this.time = time ;
        this.Username = u1.getUser();
        this.ReMessa =  new ArrayList<>();
        this.LikedBy = new ArrayList<>();
    }

    public Timestamp getTime() {return time;}

    void addreply(ReplyMessage a ){
        ReMessa.add(a);
    }

    ArrayList<ReplyMessage> getReplies(){
        return ReMessa;
    }

    void setLike(User u){
        if (!LikedBy.contains(u)) {
            LikedBy.add(u);
            likes++;
        }
        else System.out.println("You have already liked this post.");
    }

    public int getLike(){return likes;}

    public String getMinima(){return minima;}

    public String toString(){
        return "--User: " + Username + " posted:\n\t" + minima + "\n\tLikes->"
                + likes + "\tAt:" + time;
    }


}
