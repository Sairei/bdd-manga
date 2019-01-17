public class SanctuaryElement
{
    public String titre;
    public String type;
    public String genres;
    public String categories;
    public String annee;

    public int isEgal(SanctuaryElement e)
    {
        String href = titre.replaceAll("<a href=\"","");
        href = href.replaceAll("\">(.)*","");
        String href_E = e.titre.replaceAll("<a href=\"","");
        href_E = href_E.replaceAll("\">(.)*","");

        return href.compareTo(href_E);
    }
}
