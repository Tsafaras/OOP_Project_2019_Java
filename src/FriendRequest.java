import java.sql.Timestamp;

class FriendRequest {

    private User user_sent;
    private User user_received;

    enum Status{
        Accepted, Rejected, Pending
    }

    private Status status = Status.Pending;

    private Timestamp time = new Timestamp(System.currentTimeMillis());

    FriendRequest(User user1, User user2, Timestamp time){
        this.time = time;
        this.user_sent = user1;
        this.user_received = user2;
    }

    User getSent(){return user_sent;}

    User getReceived() {return user_received;}

    Status getStatus() {return this.status;}

    void setStatusE(Status x){this.status = x;}

    Timestamp getTime() {return time;}
}
