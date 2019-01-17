import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        String url = "https://www.manga-sanctuary.com";
        Map<String, String> type = new HashMap<String, String>(){{
            put("BD","-filtre-27.html");        // Bande Dessinée
            put("LN","-filtre-26.html");        // Light Novel
            put("manga","-filtre-4.html");      // Manga
            put("roman","-filtre-16.html");     // Roman
        }};
        String[] suite = {
                "/bdd/series",
                "/bdd/series-lettre-A",
                "/bdd/series-lettre-B",
                "/bdd/series-lettre-C",
                "/bdd/series-lettre-D",
                "/bdd/series-lettre-E",
                "/bdd/series-lettre-F",
                "/bdd/series-lettre-G",
                "/bdd/series-lettre-H",
                "/bdd/series-lettre-I",
                "/bdd/series-lettre-J",
                "/bdd/series-lettre-K",
                "/bdd/series-lettre-L",
                "/bdd/series-lettre-M",
                "/bdd/series-lettre-N",
                "/bdd/series-lettre-O",
                "/bdd/series-lettre-P",
                "/bdd/series-lettre-Q",
                "/bdd/series-lettre-R",
                "/bdd/series-lettre-S",
                "/bdd/series-lettre-T",
                "/bdd/series-lettre-U",
                "/bdd/series-lettre-V",
                "/bdd/series-lettre-W",
                "/bdd/series-lettre-X",
                "/bdd/series-lettre-Y",
                "/bdd/series-lettre-Z"
        };

        URLcontent content = new URLcontent(url, suite[0]+type.get("manga"));

        String table = content.format_table();
        System.out.println(table);
    }
}
