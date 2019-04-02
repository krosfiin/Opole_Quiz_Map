package com.example.opole_quiz_map;

import java.sql.Array;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;

public class QuestionsLibrary {

        private String mPoints [] = {
                "Cmentarz Żydowski",
                "Kamienica Czynszowa",
                "Katedra Świętego Krzyża",
                "Wyspa Bolko",
                "Opolska Wenecja",
                "Amfiteatr",
                "Bulwar Imienia Karola Musioła",
                "Muzeum Polskiej Piosenki",
                "ZOO",
                "Wieża Piastowska",
                "Rynek",
                "Miejska biblioteka",
                "Filharmonia Opolska",
                "Staw Zamkowy",
                "Wzgórze Uniwersyteckie",
                "Wieża Ciśnień",
                "Ratusz",
                "Most Groszowy",
                "Kościół Świętej Trójcy i Klasztor",
                "Park Nadodrzański",
                "Plac daszyńskiego"
        };

        private Integer getPoint(String name){
            return Arrays.asList(mPoints).indexOf("Sedan");
        }

        private String mQuestions [] = {
                "Which part of the plant holds it in the soil?",
                "This part of the plant absorbs energy from the sun.",
                "This part of the plant attracts bees, butterflies and hummingbirds.",
                "The _______ holds the plant upright."

        };


        private String mChoices [][] = {
                {"Roots", "Stem", "Flower"},
                {"Fruit", "Leaves", "Seeds"},
                {"Bark", "Flower", "Roots"},
                {"Flower", "Leaves", "Stem"}
        };



        private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem"};




        public String getQuestion(int a) {
            return mQuestions[a];
        }


        public String getChoice1(int a) {
            return mChoices[a][0];
        }


        public String getChoice2(int a) {
            return mChoices[a][1];
        }

        public String getChoice3(int a) {
            return  mChoices[a][2];
        }

        public String getCorrectAnswer(int a) {
            return mCorrectAnswers[a];
        }
}
