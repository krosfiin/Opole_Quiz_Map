package com.example.opole_quiz_map;

import android.widget.Switch;

public class UserData {
    private static UserData instance;

    public String id;
    public String email;
    private String password;
    private Integer score_1;
    private Integer score_2;
    private Integer score_3;
    private Integer score_4;
    private Integer score_5;
    private Integer score_6;
    private Integer score_7;
    private Integer score_8;
    private Integer score_9;
    private Integer score_10;
    private Integer score_11;
    private Integer score_12;
    private Integer score_13;
    private Integer score_14;
    private Integer score_15;
    private Integer score_16;
    private Integer score_17;
    private Integer score_18;
    private Integer score_19;

    public UserData(){

    }

    public UserData(String id, String email, String password, Integer score_1, Integer score_2, Integer score_3, Integer score_4, Integer score_5, Integer score_6, Integer score_7, Integer score_8, Integer score_9
            , Integer score_10, Integer score_11, Integer score_12, Integer score_13, Integer score_14, Integer score_15, Integer score_16, Integer score_17, Integer score_18, Integer score_19) {
        this.id = id;
        this.score_1 = score_1;
        this.score_2 = score_2;
        this.score_3 = score_3;
        this.score_4 = score_4;
        this.score_5 = score_5;
        this.score_6 = score_6;
        this.score_7 = score_7;
        this.score_8 = score_8;
        this.score_9 = score_9;
        this.score_10 = score_10;
        this.score_11 = score_11;
        this.score_12 = score_12;
        this.score_13 = score_13;
        this.score_14 = score_14;
        this.score_15 = score_15;
        this.score_16 = score_16;
        this.score_17 = score_17;
        this.score_18 = score_18;
        this.score_19 = score_19;
        this.email = email;
        this.password = password;
    }

    public void setUserData(UserData user) {
        this.id = user.id;
        this.score_1 = user.score_1;
        this.score_2 = user.score_2;
        this.score_3 = user.score_3;
        this.score_4 = user.score_4;
        this.score_5 = user.score_5;
        this.score_6 = user.score_6;
        this.score_7 = user.score_7;
        this.score_8 = user.score_8;
        this.score_9 = user.score_9;
        this.score_10 = user.score_10;
        this.score_11 = user.score_11;
        this.score_12 = user.score_12;
        this.score_13 = user.score_13;
        this.score_14 = user.score_14;
        this.score_15 = user.score_15;
        this.score_16 = user.score_16;
        this.score_17 = user.score_17;
        this.score_18 = user.score_18;
        this.score_19 = user.score_19;
        this.email = user.email;
        this.password = user.password;
    }
    public UserData getUserData() {
        return this;
    }

    public Integer getSumScore() {
        Integer score = this.score_1 + this.score_2 + this.score_3 + this.score_4 + this.score_5 + this.score_6 + this.score_7 + this.score_8 + this.score_9 + this.score_10 + this.score_11 + this.score_12
                + this.score_13 + this.score_14 + this.score_15 + this.score_16 + this.score_17 + this.score_18 + this.score_19;
        return score;
    }

    public Integer getScore(Integer score_number) {
        switch (score_number) {
            case 1:
                return this.score_1;
            case 2:
                return this.score_2;
            case 3:
                return this.score_3;
            case 4:
                return this.score_4;
            case 5:
                return this.score_5;
            case 6:
                return this.score_6;
            case 7:
                return this.score_7;
            case 8:
                return this.score_8;
            case 9:
                return this.score_9;
            case 10:
                return this.score_10;
            case 11:
                return this.score_11;
            case 12:
                return this.score_12;
            case 13:
                return this.score_13;
            case 14:
                return this.score_14;
            case 15:
                return this.score_15;
            case 16:
                return this.score_16;
            case 17:
                return this.score_17;
            case 18:
                return this.score_18;
            case 19:
                return this.score_19;
        }
        return 0;
    }

    public void setScore(Integer score_number,Integer score) {
        switch (score_number) {
            case 1:
                this.score_1 = score;
                break;
            case 2:
                this.score_2 = score;
                break;
            case 3:
                this.score_3 = score;
                break;
            case 4:
                this.score_4 = score;
                break;
            case 5:
                this.score_5 = score;
                break;
            case 6:
                this.score_6 = score;
                break;
            case 7:
                this.score_7 = score;
                break;
            case 8:
                this.score_8 = score;
                break;
            case 9:
                this.score_9 = score;
                break;
            case 10:
                this.score_10 = score;
                break;
            case 11:
                this.score_11 = score;
                break;
            case 12:
                this.score_12 = score;
                break;
            case 13:
                this.score_13 = score;
                break;
            case 14:
                this.score_14 = score;
                break;
            case 15:
                this.score_15 = score;
                break;
            case 16:
                this.score_16 = score;
                break;
            case 17:
                this.score_17 = score;
                break;
            case 18:
                this.score_18 = score;
                break;
            case 19:
                this.score_19 = score;
                break;
        }
    }


    public static synchronized UserData getInstance(){
        if(instance==null){
            instance=new UserData();
        }
        return instance;
    }

}
