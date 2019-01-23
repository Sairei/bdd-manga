public class ElementGest
{
    public String flag;
    public String link;
    public String name;

    public ElementGest(String[] str)
    {
        int posA, posB;

        posA = str[0].indexOf("flags") + 6;
        posB =  str[0].indexOf(".png");
        this.flag = str[0].substring(posA, posB);;

        posA = str[1].indexOf("\"")+1;
        posB =  str[1].length()-2;
        this.link = str[1].substring(posA, posB);

        posA = "<span>".length();
        posB = str[2].length() - "</span>".length();
        this.name = str[2].substring(posA, posB);

        nameTreatment();
    }

    public void nameTreatment()
    {

    }

    public String elemToJson()
    {
        String elem = "";

        elem += "\t\t{\n";

        elem += "\t\t\t\"name\": \"" + name + "\"";
        elem += "\n";
        elem += "\t\t\t\"link\": \"" + link + "\",";
        elem += "\n";

        elem += "\t\t}";

        return elem;
    }
}
