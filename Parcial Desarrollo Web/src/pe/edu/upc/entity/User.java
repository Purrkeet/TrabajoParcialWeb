package pe.edu.upc.entity;

import java.sql.Timestamp;

public class User 
{
    private int iduser;
    private String username;
    private String email;
    private String password;
    private Timestamp create_time;
    private String name;
    private String lastname;
    private int score;
    private String steamid;
    private String facebookid;
    private String profileinfo;

    public User() 
    {
        
    }

    public int getIduser() {return iduser;}
    public void setIduser(int iduser) {this.iduser = iduser;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Timestamp getCreate_time() {return create_time;}
    public void setCreate_time(Timestamp create_time) {this.create_time = create_time;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public String getSteamid() {return steamid;}
    public void setSteamid(String steamid) {this.steamid = steamid;}
    public String getFacebookid() {return facebookid;}
    public void setFacebookid(String facebookid) {this.facebookid = facebookid;}
    public String getProfileinfo() {return profileinfo;}
    public void setProfileinfo(String profileinfo) {this.profileinfo = profileinfo;}

    @Override
    public String toString() 
    {
        return "User{" + "iduser=" + iduser + ", username=" + username + ", email=" + email + ", password=" + password + ", create_time=" + create_time + ", name=" + name + ", lastname=" + lastname + ", score=" + score + ", steamid=" + steamid + ", facebookid=" + facebookid + ", profileinfo=" + profileinfo + '}';
    }
    
    
}
