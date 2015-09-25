package pe.edu.upc.entity;

public class Comment 
{
    private int idcomment;
    private String TEXT;
    private int score;
    
    private User user;
    private Article article;
    private Comment padre=null;

    public Comment() 
    {
        
    }

    public int getIdcomment() {return idcomment;}
    public void setIdcomment(int idcomment) {this.idcomment = idcomment;}
    public String getTEXT() {return TEXT;}
    public void setTEXT(String TEXT) {this.TEXT = TEXT;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Article getArticle() {return article;}
    public void setArticle(Article article) {this.article = article;}
    public Comment getPadre() {return padre;}
    public void setPadre(Comment padre) {this.padre = padre;}

    @Override
    public String toString() 
    {
        return "Comment{" + "idcomment=" + idcomment + ", TEXT=" + TEXT + ", score=" + score + ", user=" + user + ", article=" + article + ", padre=" + padre + '}';
    }
    
}
