
import java.io.IOException;


public class Main
{
    public static void main(String[] args)
    {
        try {
            WriteRead in_out = new WriteRead();

//            in_out.write_txt();
            in_out.write_json();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
