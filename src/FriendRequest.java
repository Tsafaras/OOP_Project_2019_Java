import java.sql.Timestamp;

class FriendRequest {

    private User user_sent;
    private User user_received;

    enum Status{
        Accepted, Rejected, Pending
    }

    private Status status = Status.Pending;

    private Timestamp time;

    FriendRequest(User user1, User user2){
        this.time = new Timestamp(System.currentTimeMillis());
        this.user_sent = user1;
        this.user_received = user2;
    }
        // Epistrefei Ton User pou to esteile.
    User getSent(){return user_sent;}

        //Epistrefei ton User pou to elave.
    User getReceived() {return user_received;}

        // Epistrefei to Status enos aitimatos - (Accepted-Rejected-Pending)
    Status getStatus() {return this.status;}

        //Setter gia to Status
    void setStatusE(Status x){this.status = x;}

        // Epistrefei tin wra pou egine to aitima.
    Timestamp getTime() {return time;}
}
