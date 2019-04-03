package com.example.opole_quiz_map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuestionQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Answer
    private static final String ANSWER = "ANSWER";

    private static final String MARKERNAME = "MARKER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + MARKERNAME + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    QuestionQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<QuestionQuiz> arraylist = new ArrayList<>();
        String markerName = "Plac Daszyńskiego";
        arraylist.add(new QuestionQuiz("Jak nazywana jest fontanna na Placu Ignacego Daszyńskiego?", "Opolska Caryca", "Opolska Ceres", "Wielka fontanna", "Opolska Ceres", markerName));
        arraylist.add(new QuestionQuiz("Co miało sie kiedyś znajdować na miejscu fontanny?", "Pompa Wodna", "Obora", "Studnia", "Studnia", markerName));
        arraylist.add(new QuestionQuiz("Kiedy ukończono budowę fontanny?", "1907", "1909", "1986", "1907", markerName));
        arraylist.add(new QuestionQuiz("Co symbolizują rzeźby fontanny?", "Opolski przemysł wapienniczy i porcelanowy", "Opolskie rybactwo, przemysł porcelanowy oraz wapienniczy", "Opolskie rybactwo, przemysł wapienniczy oraz rolnictwo", "Opolskie rybactwo, przemysł wapienniczy oraz rolnictwo", markerName));
        arraylist.add(new QuestionQuiz("Jaka bogini znajduje się na fontannie?", "Bogini Hesti", "Bogini Ceres", "Bogini Ateny", "Bogini Ceres", markerName));
        markerName = "Most Groszowy";
        arraylist.add(new QuestionQuiz("Jak inaczej nazywany jest Most Groszowy w Opolu?", "Most Zakochanych", "Most Przyjaźni", "Most Pamiętnych Chwil", "Most Zakochanych", markerName));
        arraylist.add(new QuestionQuiz("W którym roku wybudowano most?", "1902", "1897", "1894", "1894", markerName));
        arraylist.add(new QuestionQuiz("Jak żartobliwie nazywano zachodnią stronę ulicy Krakowskiej?", "Droga do przodu", "Droga do małżeństwa", "Droga do rozwodu ", "Droga do małżeństwa", markerName));
        arraylist.add(new QuestionQuiz("Skąd wywodzi się nazwa mostu?", "Nazwa mostu wywodzi się od architekta który miał na nazwisko Groszowski ", "Kiedyś za przejście przez most były pobierane opłaty jednego grosza", "W czasie budowy wszyscy mieszkańcy miasta musieli przeznaczyć na budowę jeden grosz", "Kiedyś za przejście przez most były pobierane opłaty jednego grosza", markerName));
        arraylist.add(new QuestionQuiz("Od którego roku most jest oświetlany nocą?", "2013", "2010", "1999", "2010", markerName));
        markerName = "Staw Zamkowy";
        arraylist.add(new QuestionQuiz("Jak nazywa się zabytkowy drewniany dom nad Stawem Zamkowym?", "Domek Drewniany ", "Domek Lodowy", "Domek Stawowy", "Domek Lodowy", markerName));
        arraylist.add(new QuestionQuiz("W którym roku  odbyły się mistrzostwa Niemiec w jeździe figurowej na Stawie?", "1937", "1944", "1934", "1934", markerName));
        arraylist.add(new QuestionQuiz("Na co przebudowano Staw?", "Na studnie", "Na parking", "Na fontannę", "Na fontannę", markerName));
        arraylist.add(new QuestionQuiz("Skąd pochodziły materiały do budowy Stawu?", "Z części fosy ", "Z Odry ", "Z murów zamkowych ", "Z części fosy ", markerName));
        arraylist.add(new QuestionQuiz("W którym roku zainstalowana została multimedialna fontanna muzyczna?", "2013", "2014", "2011", "2013", markerName));
        markerName = "Wieża Piastowska";
        arraylist.add(new QuestionQuiz("Jaką funkcję pełniła kiedyś Wieża?", "Śtrażnicy na wyspie Pasieka", "Punktu widokowego", "Posterunku straż miejskiej ", "Śtrażnicy na wyspie Pasieka", markerName));
        arraylist.add(new QuestionQuiz("Jaką wysokość ma Wieża?", "42m", "35m", "53m", "42m", markerName));
        arraylist.add(new QuestionQuiz("Za rządów jakiego księcia wybudowano Więżę Piastowską", "Zbigniewa Małego", "Bolka I", "Karolka II", "Bolka I", markerName));
        arraylist.add(new QuestionQuiz("W którym roku wybuchł pożar Wieży?", "1739", "1741", "1853", "1739", markerName));
        arraylist.add(new QuestionQuiz("Czym ozdobiona jest iglica Wieży Piastowskiej", "Syrenką", "Orłem", "Kogutem ", "Orłem", markerName));
        markerName = "Opolska Wenecja";
        arraylist.add(new QuestionQuiz("Jaką inną nazwę nosi Opolska Wenecja?", "Stołówka", "Wodówka", "Młynówka", "Młynówka", markerName));
        arraylist.add(new QuestionQuiz("Do którego roku stanowiła główne koryto Odry?", "1600", "1650", "1700", "1600", markerName));
        arraylist.add(new QuestionQuiz("Od czego oddziela prawobrzeżną część miasta?", "Wyspy Pasieki", "Wyspy Zamkowej", "Drugiego brzegu", "Wyspy Pasieki", markerName));
        arraylist.add(new QuestionQuiz("Jaką nazwę nosi most w pobliżu Opolskiej wenecji?", "Młody Mostek", "Nowy Mostek", "Szczęśliwy Mostek", "Młody Mostek", markerName));
        arraylist.add(new QuestionQuiz("W którym roku wybudowano śluzę?", "1866", "1862", "1963", "1862", markerName));
        markerName = "Katedra Świętego Krzyża";
        arraylist.add(new QuestionQuiz("Co niezwykłego znajduje się w kościele?", "Obraz Matki Boskiej Opolskiej", "Obraz Matki Boskiej Urodzajnej ", "Obraz Matki Boskiej Wielkopolskiej ", "Obraz Matki Boskiej Opolskiej", markerName));
        arraylist.add(new QuestionQuiz("W którym roku wpisano świątynię do rejestru zabytków?", "1953", "1964", "1975", "1964", markerName));
        arraylist.add(new QuestionQuiz("Co umieszczono po obu stronach tabernakulum?", "Krzyże ", "Figury aniołów", "Figury apostołów", "Figury aniołów", markerName));
        arraylist.add(new QuestionQuiz("W którym roku powstał ołtarz główny?", "1773", "1777", "1737", "1773", markerName));
        arraylist.add(new QuestionQuiz("Gdzie powstała scena ukrzyżowania znajdująca się w centrum katedry?", "W Monachium", "W Watykanie", "W Paryżu", "W Monachium", markerName));
        markerName = "Kościół Świętej Trójcy i Klasztor";
        arraylist.add(new QuestionQuiz("Do jakiej parafi należy kościół?", "Parafi Matki Boskiej Opolskiej", "Parafi Podwyższenia Krzyża Świętego", "Parafi Wywyższenia Jezusa", "Parafi Podwyższenia Krzyża Świętego", markerName));
        arraylist.add(new QuestionQuiz("W którym roku został wpisany do rejestru zabytków?", "1964", "1977", "1965", "1964", markerName));
        arraylist.add(new QuestionQuiz("Jaki klasztor przylega do kościoła?", "Klasztor fraciszkanów", "Klasztor templariuszy ", "Klasztor jezuitów ", "Klasztor fraciszkanów", markerName));
        arraylist.add(new QuestionQuiz("Co znajduje się pomiędzy kościołem a klasztorem?", "Kaplica św. Anny", "Kaplica św. Ludwika ", "Kaplica św. Błażeja", "Kaplica św. Anny", markerName));
        arraylist.add(new QuestionQuiz("Czyja rzeźba  stoi przed kościołem?", "Jana Pawła II", "Jana Chrzciciela ", "Jana Nepomucena", "Jana Nepomucena", markerName));
        markerName = "Rynek";
        arraylist.add(new QuestionQuiz("Jaka armia najechała rynek w 1945?", "Armia Zielona", "Armia Czerwona", "Armia Aliancka ", "Armia Czerwona", markerName));
        arraylist.add(new QuestionQuiz("Po wojnie polscy architekci nadali jaki kształt nowym budynkom?", "Nawiązujący do baroku", "Nawiązujący do rokoko", "Nawiązujący do renesansu", "Nawiązujący do baroku", markerName));
        arraylist.add(new QuestionQuiz("Jak nazywał się hotel który zastąpił pierwszy opolski zajazd pocztowy?", "Pod Orłem", "Przy Oderce ", "Pod Pocztą", "Pod Orłem", markerName));
        arraylist.add(new QuestionQuiz("Jak inaczej nazywała się kamienica książęca", "Pod Jeleniem ", "Pod Orłem", "Pod Lwem", "Pod Lwem", markerName));
        arraylist.add(new QuestionQuiz("Jaki król zatrzymał się w kamienicy książęcej", "Jan Kazimierz Wielki", "Jan Kazimierz Waza", "Władysław IV Łokietek", "Jan Kazimierz Waza", markerName));
        markerName = "Ratusz";
        arraylist.add(new QuestionQuiz("Jaką funkcje pełnił budynek będący dzisiaj ratuszem?", "drewniany dom kupiecki", "zawsze był ratuszem", "stajni ", "drewniany dom kupiecki", markerName));
        arraylist.add(new QuestionQuiz("Kiedy zakończono budowę ratusza?", "1935", "1936", "1934", "1936", markerName));
        arraylist.add(new QuestionQuiz("W którym roku postawiono więżę ratuszową?", "1720", "1739", "1740", "1740", markerName));
        arraylist.add(new QuestionQuiz("W jakim stylu postawiono wieżę ratuszową", "W stylu gotyckim", "W stylu rokoko", "W stylu barokowym", "W stylu barokowym", markerName));
        arraylist.add(new QuestionQuiz("W którym roku runęła wieża ratuszowa?", "1934", "1943", "1933", "1934", markerName));
        markerName = "Kamienica Czynszowa";
        arraylist.add(new QuestionQuiz("Czym jest Kamienica Czynszowa?", "Barem ", "Muzeum", "Kamienicą Mieszkalną ", "Muzeum", markerName));
        arraylist.add(new QuestionQuiz("Z którego wieku pochodzi kamienica czynszowa?", "XVIII", "XX", "XIX", "XIX ", markerName));
        arraylist.add(new QuestionQuiz("Do kogo należał dom pod numerem 9?", "Zbigniewów ", "Nowaków", "Kowalskich ", "Nowaków", markerName));
        arraylist.add(new QuestionQuiz("Z którego roku pochodzą najstarsze meble ?", "1890", "1801", "1770", "1890", markerName));
        arraylist.add(new QuestionQuiz("Co mieściło się kiedyś w miejscu Kamienicy Czynszowej?", "Pensjonat dla dziewcząt", "Akademik", "Mieszkania urzędników ", "Pensjonat dla dziewcząt", markerName));
        markerName = "Wzgórze Uniwersyteckie";
        arraylist.add(new QuestionQuiz("Jak nazywaja się budynki Uniwersytetu Opolskiego przy wzgórzu?", "Collegium Maius i Minus", "Collegium Posejdus i Zeus", "Collegium Marsus i Minus", "Collegium Maius i Minus", markerName));
        arraylist.add(new QuestionQuiz("Jak nazywa się skwer we wschodniej części wzgórza?", "Skwer Pisarzy ", "Skwer Hutników ", "Skwer Artystów", "Skwer Artystów", markerName));
        arraylist.add(new QuestionQuiz("Z czym jest związana twórczość wyrzeźbionych artystów?", "Z Opolem i województwem opolskim ", "Z Odrą i Zamkiem ", "Z Opolem i Festiwalem polskiej Piosenki", "Z Opolem i Festiwalem polskiej Piosenki", markerName));
        arraylist.add(new QuestionQuiz("Na jakiej wysokości mieści się wzgórze?", "165 m n.p.m", "205 m n.p.m", "173 m n.p.m", "165 m n.p.m", markerName));
        arraylist.add(new QuestionQuiz("Jak kiedyś nazywano wzgórze?", "Górą Pod Zamkową", "Górą Wapienną", "Górą Zamkową", "Górą Wapienną", markerName));
        markerName = "Wieża Ciśnień";
        arraylist.add(new QuestionQuiz("Z którego roku pochodzi budowla?", "1900", "1911", "1896", "1896", markerName));
        arraylist.add(new QuestionQuiz("Jak nazywał się inżynier będący projektantem budowy?", "Groszow", "Pfeffera", "Lemenon", "Pfeffera", markerName));
        arraylist.add(new QuestionQuiz("Jaką wysokość ma wieża?", "48m", "51m", "44m", "48m", markerName));
        arraylist.add(new QuestionQuiz("Od którego roku wieża jest nieużytkowana?", "2002", "2015", "1999", "2002", markerName));
        arraylist.add(new QuestionQuiz("Jaką pojemność posiada stalowy zbiornik?", "950 m3", "1000 m3", "750 m3", "750 m3", markerName));
        markerName = "Cmentarz Żydowski";
        arraylist.add(new QuestionQuiz("W którym roku powstał cmentarz?", "1922", "1822", "1844", "1822", markerName));
        arraylist.add(new QuestionQuiz("Na terenie jakiej wsi został założony cmentarz?", "Wójtowej Wsi", "Wsi Pod Opolskiej", "Nowej Wsi Królewskiej", "Nowej Wsi Królewskiej", markerName));
        arraylist.add(new QuestionQuiz("W którym roku odbył się ostatni pogrzeb na cmentarzu?", "1940", "1945", "1922", "1940", markerName));
        arraylist.add(new QuestionQuiz("W którym roku Fundacja Ochrony Dziedzictwa Żydownkiego zrobiła prace porządkowe?", "2004", "1995", "2005", "2005", markerName));
        arraylist.add(new QuestionQuiz("Ile nagrobków zachowało się na cmentarzu?", "ok 150", "ok 200", "ok 175", "ok 150", markerName));
        markerName = "Wyspa Bolko";
        arraylist.add(new QuestionQuiz("Na jakiej rzece znajduje się wypsa?", "Na Wiśle ", "Na Odrze", "Na Dunajcu ", "Na Odrze", markerName));
        arraylist.add(new QuestionQuiz("Jak kiedyś nazywano wyspę?", "Usypówka", "Hołda", "Kępa", "Kępa", markerName));
        arraylist.add(new QuestionQuiz("Od którego wieku wyspa jest nazywana Bolko?", "XIV", "XVI", "XV", "XIV", markerName));
        arraylist.add(new QuestionQuiz("Na czyją cześć wyspa przyjęła nazwę Wyspy Bolko?", "Księżnej piastowskiej", "Króla piastowskiego", "Księcia piastowskiego", "Księcia piastowskiego", markerName));
        arraylist.add(new QuestionQuiz("W którym roku radni zdecydowali się utworzyć park miejski na wyspie?", "1910", "1920", "1915", "1910", markerName));
        markerName = "ZOO";
        arraylist.add(new QuestionQuiz("Jaką powierzchnię zajmuje ZOO?", "30 ha", "20 ha", "35 ha", "30 ha", markerName));
        arraylist.add(new QuestionQuiz("Ile gatunków zwierząt znajduje się w ZOO?", "234", "199", "227", "227", markerName));
        arraylist.add(new QuestionQuiz("Kiedy wybudowano Ogród Zoologiczny?", "1941", "1912", "1914", "1912", markerName));
        arraylist.add(new QuestionQuiz("Jak w XX wieku nazywał się ogród?", "Ogród Bolko", "Zacisze Bolko", "Tierpark Bolko", "Tierpark Bolko", markerName));
        arraylist.add(new QuestionQuiz("W którym roku po wojnie otworzono ponownie ZOO?", "1953", "1973", "1950", "1953", markerName));
        markerName = "Bulwar Imienia Karola Musioła";
        arraylist.add(new QuestionQuiz("W którym roku urodził się Karol Musiał?", "1907", "1905", "1903", "1905", markerName));
        arraylist.add(new QuestionQuiz("Przy jakim moście znajduje się pomnik Karola Musiała?", "Groszowym", "Złotym", "Żółtym", "Żółtym", markerName));
        arraylist.add(new QuestionQuiz("W którym roku powstała Pasieka?", "1600", "1660", "1690", "1600", markerName));
        arraylist.add(new QuestionQuiz("Jak nazywa się główna ulica dzielnicy?", "ul. Wojska Polskiego ", "ul. Oleska ", "ul.Piastowska", "ul.Piastowska", markerName));
        arraylist.add(new QuestionQuiz("Na jakiej części wyspy znajdował się w średniowieczu gród obronny Polan?", "Wschodzie", "Zachodzie", "Północy", "Północy", markerName));
        markerName = "Park Nadodrzański";
        arraylist.add(new QuestionQuiz("Czyje popiersie znajduje się w parku?", "Opolskiej Junony", "Bolko", "Jana Pawła II", "Opolskiej Junony", markerName));
        arraylist.add(new QuestionQuiz("Jak nazywa się statek wycieczkowy?", "Oderka", "Opolanin", "Duma Opola", "Opolanin", markerName));
        arraylist.add(new QuestionQuiz("Jaką powierzchnię zajmuje park?", "6 ha", "10 ha", "5 ha", "6 ha", markerName));
        arraylist.add(new QuestionQuiz("W którym roku powstał park?", "ok 1800", "ok 1900", "ok 1700", "ok 1800", markerName));
        arraylist.add(new QuestionQuiz("Jaki obwód pnia posiada dąb szypułkowy będący ponikiem przyrody?", "399 cm", "465 cm", "432 cm", "432 cm", markerName));
        markerName = "Filharmonia Opolska";
        arraylist.add(new QuestionQuiz("Czyjego imienia jest Filcharmonia Opolska?", "Józefa Stalina ", "Adama Mickiewicza ", "Józefa Elsnera", "Józefa Elsnera", markerName));
        arraylist.add(new QuestionQuiz("W którym roku założono Orkiestrę Symfoniczną Filharmoni Opolskiej?", "1968", "1952", "1956", "1952", markerName));
        arraylist.add(new QuestionQuiz("Na jaką nazwę przemianowano Orkiestrę Symfoniczną Filharmoni Opolskiej?", "Chwalebną Orkiestrę Symfoniczną", "Opolską Orkiestrę Symfoniczną", "Państwową Orkiestrę Symfoniczną", "Państwową Orkiestrę Symfoniczną", markerName));
        arraylist.add(new QuestionQuiz("W którym roku orkiestra brała udział w wydarzeniu w Rzymie?", "2002", "2000", "2011", "2000", markerName));
        arraylist.add(new QuestionQuiz("Czyje obchody 80-tych urodzin uświetnił zespół?", "Jana Pawła II", "Kardynała Dziwisza", "Benedykta XVI", "Jana Pawła II", markerName));
        markerName = "Muzeum Polskiej Piosenki";
        arraylist.add(new QuestionQuiz("W którym roku założono Muzeum Polskiej Piosenki?", "2007", "2005", "2003", "2007", markerName));
        arraylist.add(new QuestionQuiz("Jakie zbiory posiada muzeum?", "Zbiory związane z Opolem", "Zbiory związane z polską piosenką", "Zbiory związane z województwem opolskim", "Zbiory związane z polską piosenką", markerName));
        arraylist.add(new QuestionQuiz("Co było celem akcji pod hasłem 'Piosenka ma swoje historie'?", "Gromadzenie piosenek ludowych", "Gromadzenie pamiątek związanych z polską piosenką", "Gromadzenie starych instrumentów ", "Gromadzenie pamiątek związanych z polską piosenką", markerName));
        arraylist.add(new QuestionQuiz("Kiedy zorganizowano pierwszą wystawę czasową w muzeum?", "2009", "2015", "2010", "2009", markerName));
        arraylist.add(new QuestionQuiz("Jaką nazwę nosiła pierwsza wystawa czasowa w muzeum?", "Muzyka to pamięć", "Grunt to bunt", "Szczęście to śpiew ", "Grunt to bunt", markerName));


        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<QuestionQuiz> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (QuestionQuiz question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(ANSWER, question.getAnswer());
                values.put(MARKERNAME, question.getMarkerName());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public int checkDBquestions() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String column[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, column, null,null, null, null, null);
        db.endTransaction();
        return cursor.getCount();
    }


    public List<QuestionQuiz> getAllOfTheQuestions(String markerName) {

        List<QuestionQuiz> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String column[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, column, MARKERNAME+ "=?", new String[]{markerName}, null, null, null);


        while (cursor.moveToNext()) {
            QuestionQuiz question = new QuestionQuiz();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setAnswer(cursor.getString(5));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
