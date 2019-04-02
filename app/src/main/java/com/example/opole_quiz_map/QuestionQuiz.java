package com.example.opole_quiz_map;

public class QuestionQuiz {
    private int id;
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String answer;
    private String markerName;

    public QuestionQuiz(String q, String oa, String ob, String oc, String ans, String mn) {

        question = q;
        opta = oa;
        optb = ob;
        optc = oc;
        answer = ans;
        markerName = mn;
    }

    public QuestionQuiz() {
        id = 0;
        question = "";
        opta = "";
        optb = "";
        optc = "";
        answer = "";
    }

    public String getQuestion() {
        return question;
    }

    public String getOptA() {
        return opta;
    }

    public String getOptB() {
        return optb;
    }

    public String getOptC() {
        return optc;
    }


    public String getAnswer() {
        return answer;
    }

    public String getMarkerName() {
        return markerName;
    }

    public void setId(int i) {
        id = i;
    }

    public void setQuestion(String q1) {
        question = q1;
    }

    public void setOptA(String o1) {
        opta = o1;
    }

    public void setOptB(String o2) {
        optb = o2;
    }

    public void setOptC(String o3) {
        optc = o3;
    }

    public void setAnswer(String ans) {
        answer = ans;
    }

}
