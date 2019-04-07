import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class mine {

	public static void main(String[] args) {
		ArrayList<String> links = new ArrayList<String>();
		int counter = 0;
		String mainurl = "https://www.visual-meta.com/";
		links.add(mainurl);
		try {
			while(links.size() <= 999)
			{
				String currenturl = links.get(counter);
				System.out.println("===============");
				System.out.println("current url : " + currenturl);
				System.out.println("===============");
				
				Document doc = Jsoup.connect(currenturl).get();
				Elements elements = doc.select("a");
				int size = elements.size();
				
				for(int i=1 ; i<size ; i++)
				{
					String link = elements.get(i).attr("href");
					
					if ( link.length() > 4)
					{
						if (!link.startsWith("http"))
						{
							link = mainurl + link;
						}
						links.add(link);
						System.out.println(link);
					}		
				}
				counter++;
			}
			System.out.println("\n1000 Urls rerieved.");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("invalid url");
		}
	}
}
