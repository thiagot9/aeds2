import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Games {
    private int app_id, age, dlcs, avg_pt;
    private String name, release_date, owners, website, developers;
    private float price, upvotes;
    private ArrayList<String> languages;// = new ArrayList<>();
    private boolean windows, mac, linux;
    private ArrayList<String> genres; // = new ArrayList<>();

    public int tratarStringParaInt(String s) {
        int resp = 0;
        resp = Integer.parseInt(s);

        return resp;
    }

    public float tratarStringParaFloat(String string) {
        float resp = 0.0f;
        resp = Float.parseFloat(string);

        return resp;
    }

    public boolean tratarStringParaBoolean(String string) {
        boolean resp = false;
        if (string == "true") {
            resp = true;

        }
        return resp;
    }

    public ArrayList<String> tratarStringParaArrayList(String string) {
        ArrayList languages = new ArrayList<String>();

        String replace  = string.replace("[", "");
        String replace1 = replace.replace("]", "");

        String[] strgArray = replace1.split(",");
        languages.addAll(Arrays.asList(strgArray));

        return languages;
    }

    Games() {

    }

    Games(String name, String release_date, String owners, int age, float price, int dlcs, ArrayList<String> languages,
            String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers,
            ArrayList<String> genres) {

        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;

    }

    Games(String name, String release_date, String owners, String age, String price, String dlcs, String languages,
            String website, String windows, String mac, String linux, String upvotes, String avg_pt, String developers,
            String genres) {

        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = tratarStringParaInt(age);
        this.price = tratarStringParaFloat(price);
        this.dlcs = tratarStringParaInt(dlcs);
        this.languages = tratarStringParaArrayList(languages);
        this.website = website;
        this.windows = tratarStringParaBoolean(windows);
        this.mac = tratarStringParaBoolean(mac);
        this.linux = tratarStringParaBoolean(linux);
        this.upvotes = tratarStringParaFloat(upvotes);
        this.avg_pt = tratarStringParaInt(avg_pt);
        this.developers = developers;
        this.genres = tratarStringParaArrayList(genres);

    }

    public int getApp_id() {
        return app_id;

    }

    public int getAge() {
        return age;

    }

    public int getDlcs() {
        return dlcs;

    }

    public int getAvg_pt() {
        return avg_pt;

    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOwners() {
        return owners;
    }

    public String getWebsite() {
        return website;
    }

    public String getDevelopers() {
        return developers;
    }

    public float getPrice() {
        return price;

    }

    public float getUpvotes() {
        return upvotes;
    }

    public boolean getWindows() {
        return windows;
    }

    public boolean getMac() {
        return mac;
    }

    public boolean getLinux() {
        return linux;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages.addAll(languages);
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres.addAll(genres);
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;

    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;

    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public static void main(String[] args) {
        String linepub = "";
        String linegames = "";
        String splitBy = ",";

        try {
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("pub.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("games.csv"));
            BufferedReader br3 = new BufferedReader(new FileReader("final.txt"));
            while ((linepub = br.readLine()) != null) // returns a Boolean value
            {
                int id = 0; //

                id = Integer.parseInt(linepub); // guardar o id do jogo do arquivo pub.in

                while ((linegames = br2.readLine()) != null) // returns a Boolean value
                {
                    int id2 = 0;
                    String[] informacao = linegames.split(splitBy); // armazenar dados da linha de 'game.csv'
                    id2 = Integer.parseInt(informacao[0]); // transformar a primeira informação da linha de 'game.csv'
                                                           // de string para int

                    if (id == id2) // se a id do jogo do arquivo 'pub.in' for encontrado em 'games.csv'...
                    {

                        


                        Games jogo = new Games(informacao[1], informacao[2], informacao[3], informacao[4], informacao[5], informacao[6], informacao[7], informacao[8], informacao[9], informacao[10], informacao[11], informacao[12], informacao[13], informacao[14], informacao[15]);
                        


                        // guardarInfos();
                        // tratarInfos();
                        // guardarInfos();

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
