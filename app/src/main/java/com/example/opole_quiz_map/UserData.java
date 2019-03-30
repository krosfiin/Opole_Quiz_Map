package com.example.opole_quiz_map;

public class UserData {
    private static UserData instance;

    public String id;
    public String email;
    public String password;
    public Integer score;

    public UserData(String id, String email, String password, Integer score) {
        this.id = id;
        this.score = score;
        this.email = email;
        this.password = password;
    }

    public UserData() {

    }

    public void setUserData(UserData user) {
        this.id = user.id;
        this.score = user.score;
        this.email = user.email;
        this.password = user.password;
    }

    public UserData getUserData() {
        return this;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static synchronized UserData getInstance(){
        if(instance==null){
            instance=new UserData();
        }
        return instance;
    }

}
