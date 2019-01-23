import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLcontent{
    public URL url;
    public String html = "";

    private final static String A = "<ul class=\"nav-liste\">";
    private final static String B = "<!-- End Content -->\n";

    public URLcontent(String url, String url_suite) {
        try {
            this.url = new URL(url + url_suite);
            URLConnection conn = this.url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                html += inputLine + '\n';
            }
            br.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Récupere le contenu d'une table dans un fichier html
    public String substring()
    {
        int posA = html.indexOf(A);
        int posB = html.indexOf(B);

        String table = html.substring(posA, posB);

        return table;
    }

    // Formate proprement une table (très spécifique)
    public String format_table()
    {
        String table = substring();

        table = table.replaceAll("</div>", ""); // supprime les div
        table = table.replaceAll("\t", "");     // supprime les tabulations
        table = table.replaceAll(" ( )+", "");  // supprime multiple espace

        table = table.replaceAll("\n</li>\n<li>", "");
        table = table.replaceAll("<ul class=\"nav-liste\">\n<li>\n", "");
        table = table.replaceAll("\n</a>\n\n</li>\n</ul>", "");

        table = table.replaceAll(" class=[^>]*","");

        table = table.replaceAll("\n(\n)+", "\n");// supprime multiple saut

        return table;
    }
}