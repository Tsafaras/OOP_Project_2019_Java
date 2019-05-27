class Wall
{
    private User user;

    Wall(User user){
        this.user = user;
    }

    void DisplayPosts() {
        for (int i=0 ;i<user.getMessages().size();i++) {
            System.out.println(user.getMessages().get(i));
            if ( user.getMessages().get(i).getReplies().size()>0)
                System.out.println("\t-----Comments of this post-----");
            for (int j=0 ; j<user.getMessages().get(i).getReplies().size();j++){
                System.out.println("\t"+user.getMessages().get(i).getReplies().get(j));
            }
        }
    }
}


