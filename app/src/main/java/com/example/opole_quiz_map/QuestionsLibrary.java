package com.example.opole_quiz_map;

import java.sql.Array;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;

public class QuestionsLibrary {

        private String mPoints [] = {
                "LIPNY STRING",
                "Cmentarz Żydowski",
                "Kamienica Czynszowa",
                "Katedra Świętego Krzyża",
                "Wyspa Bolko",
                "Opolska Wenecja",
                "Bulwar Imienia Karola Musioła",
                "Muzeum Polskiej Piosenki",
                "ZOO",
                "Wieża Piastowska",
                "Rynek",
                "Filharmonia Opolska",
                "Staw Zamkowy",
                "Wzgórze Uniwersyteckie",
                "Wieża Ciśnień",
                "Ratusz",
                "Most Groszowy",
                "Kościół Świętej Trójcy i Klasztor",
                "Park Nadodrzański",
                "Plac Daszyńskiego"
        };

        public Integer getPoint(String name){
            return Arrays.asList(mPoints).indexOf(name);
        }
}
