import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLcontent{
    public URL url;
    public String html = "";

    private final static String A = "<table";
    private final static String B = "</table>";

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
    public String substring_table()
    {
        int posA = html.indexOf(A);
        int posB = html.indexOf(B) + B.length();

        String table = html.substring(posA, posB);

        return table;
    }

    // Formate proprement une table (très spécifique)
    public String format_table()
    {
        String table = substring_table();

        table = table.replaceAll("\t", "");     // supprime les tabulations
        table = table.replaceAll(" ( )+", "");  // supprime multiple espace

        table = table.replaceAll("\\)</span>", "");
        table = table.replaceAll(" <span style=\"color:#484848;font-style:italic;\">\\(", "</td>\n<td>");

        table = table.replaceAll(" class=[^>]*","");
        table = table.replaceAll(" style=[^>]*","");
        table = table.replaceAll(" title=[^>]*","");

        table = table.replaceAll("<img[^>]*","");
        table = table.replaceAll("<td>></td>","");

        table = table.replaceAll("<table>","");
        table = table.replaceAll("</table>","");

        table = table.replaceAll("<th>Note</th>","");

        table = table.replaceAll("\n[^<]*\n", "\n");

        int pos = table.indexOf("</tr>") + "</tr>".length();
        table = table.substring(pos+1);

        return table;
    }
}