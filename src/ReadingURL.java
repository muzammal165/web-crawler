import java.net.*;
import java.io.*;
public class ReadingURL {

	public String getHTML(String url) throws IOException  {

		URL urlObj = new URL(url);
        URLConnection urlConnection = urlObj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    urlConnection.getInputStream()));
   
        String html = "";
        String inputLine;
      
        while ((inputLine = in.readLine()) != null)
        {
        	html = html + inputLine;
        }
        in.close();
        return html;
	}

}
