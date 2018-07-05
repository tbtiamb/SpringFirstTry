package firstTry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String args[]) {
        RestClient restClient = new RestClient();
//        System.out.println(restClient.get("https://yandex.ru/images/search?text=%D1%8F%D0%B1%D0%BB%D0%BE%D0%BA%D0%BE"));
//        Pattern pattern = Pattern.compile(".* src=\"([^']*)\".*");
        // String mydata = "some string with href=\"the data i want\" inside";
        // String mydata = restClient.get("https://www.bing.com/images/search?q=apple");
        //System.out.println(mydata);
        //Matcher matcher = pattern.matcher(mydata);
        //if(matcher.matches()) {
        //    System.out.println(matcher.group(1));
        // }
//        String content = null;
//        URLConnection connection = null;
//        try {
//            connection =  new URL("https://yandex.ru/images/search?text=apple").openConnection();
//          //  connection.addRequestProperty("User-Agent",
//          //          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
//            Scanner scanner = new Scanner(connection.getInputStream());
//            scanner.useDelimiter("\\Z");
//            content = scanner.next();
//        }catch ( Exception ex ) {
//            ex.printStackTrace();
//        }
//        System.out.println(content);
//    }
        try {
            Document doc = Jsoup.connect("https://www.google.ru/search?q=apfel&source=lnms&tbm=isch").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36").get();
            Elements newsHeadlines = doc.getElementsByClass("rg_bx rg_di rg_el ivg-i");
            Pattern ppattern = Pattern.compile(".*\"ou\":\"([^\"]*).*");

            for (Element element : newsHeadlines){
                Matcher matcher = ppattern.matcher(element.text());
                if(matcher.matches()) {
                    System.out.println(matcher.group(1));
                }
               // System.out.println(element.text());

            }


        }
        catch (Exception e){
            System.out.println("Smth wrong");
        }

    }
}
