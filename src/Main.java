import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        String url = enterURL();
        readContent(url);
    }

    public static void readContent(String url) throws Exception{
        try {
            URL site = new URL(url);
            URLConnection URLconnectionStream = site.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            URLconnectionStream.getInputStream()
                    )
            );

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (Exception e) {
            System.out.println("URL incorrect. Pls write correct URL\n");
            String urlException = enterURL();
            readContent(urlException);
        }
    }

    public static String enterURL () {
        System.out.println("Enter yours URL for request\n");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();

        return url;
    }

    public static boolean rightURL (String url) {
        if (url.equals("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")){
            return true;
        }
        return false;
    }
}
