import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        while(true){
            try {
                String url = enterURL();
                readContent(url);
                break;
            } catch (MalformedURLException e) {
                System.out.println("URL incorrect. Pls write correct URL:");
            } catch (Exception e) {
                System.out.println("No access to the specified resource. Pls try again with another resource:");
            }
        }
    }

    public static void readContent(String url) throws Exception{
            URL site = new URL(url);
            URLConnection UrlConnectionStream = site.openConnection();
            BufferedReader in = new BufferedReader( new InputStreamReader( UrlConnectionStream.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
    }

    public static String enterURL () {
        System.out.println("Enter yours URL for request:");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();

        return url;
    }
/*
    public static boolean rightURL (String url) {
        if (url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
            return true;
        }
        return false;
    }
 */
}
