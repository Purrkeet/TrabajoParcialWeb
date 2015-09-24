package pe.edu.upc.entity;

import java.util.Date;



public class Article 
{
    private int idarticle;
    private int score;
    private String text;
    private int numviews;
    private Date create_time;
    
    private Date update_time;
    
    private User user;

    public Article() 
    {
        numviews = 0;
        score = 0;
        create_time.getTime();
        update_time.getTime();
        
    }

    public int getNumviews() {return numviews;}
    public void setNumviews(int numviews) {this.numviews = numviews;}
      public int getIdarticle() {return idarticle;}
    public void setIdarticle(int idarticle) {this.idarticle = idarticle;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

  



    @Override
    public String toString() {
        return "Article{" + "idarticle=" + idarticle + ", score=" + score + ", text=" + text + ", numviews=" + numviews + ", create_time=" + getCreate_time() + ", update_time=" + getUpdate_time() + ", user=" + user.toString() + '}';
    }

    /**
     * @return the create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * @param create_time the create_time to set
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * @return the update_time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param update_time the update_time to set
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    
    
    
    
}
