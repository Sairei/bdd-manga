import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteRead
{
    private final static String url = "https://www.bedetheque.com/";
    private final static String[] suite = {
            "bandes_dessinees_0",
            "bandes_dessinees_A",
            "bandes_dessinees_B",
            "bandes_dessinees_C",
            "bandes_dessinees_D",
            "bandes_dessinees_E",
            "bandes_dessinees_F",
            "bandes_dessinees_G",
            "bandes_dessinees_H",
            "bandes_dessinees_I",
            "bandes_dessinees_J",
            "bandes_dessinees_K",
            "bandes_dessinees_L",
            "bandes_dessinees_M",
            "bandes_dessinees_N",
            "bandes_dessinees_O",
            "bandes_dessinees_P",
            "bandes_dessinees_Q",
            "bandes_dessinees_R",
            "bandes_dessinees_S",
            "bandes_dessinees_T",
            "bandes_dessinees_U",
            "bandes_dessinees_V",
            "bandes_dessinees_W",
            "bandes_dessinees_X",
            "bandes_dessinees_Y",
            "bandes_dessinees_Z"
    };

    public static void write_txt() throws IOException
    {
        for(String s : suite)
        {
            URLcontent content = new URLcontent(url, s + ".html");

            String c = content.format_table();

            FileWriter fichier = new FileWriter(s + ".txt");
            fichier.write(c);
            fichier.close();

            System.out.println(s + ".txt : DONE");
        }
    }

    public static void write_json() throws IOException
    {
        int i = 0;
        int posA, posB;
        String json = "{\n";
        json += "\tlivres = [\n";

        String file = "";
        for (String ligne : Files.readAllLines(Paths.get(suite[0]+".txt")))
        {
            if(file != "")
                file += "\n";
            file += ligne;
        }

        String[] str = file.split("\n</a>\n");
        for(String s : str)
        {
            String[] tab = s.split("\n");

            ElementGest e = new ElementGest(tab);
            json += e.elemToJson();

            i++;
            if(i < str.length)
                json += ",";

            json += "\n";
        }

        json += "\t]\n";
        json += "}";

        System.out.println(json);
    }
}
