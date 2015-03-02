package demo;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.URL;

public class Main{ 
	public static void main(String [] args) throws IOException
	{
		System.out.println(contentFromClasspath(args[0]));	
	}
	public static String contentFromClasspath(String name) throws IOException{
   URL resource = Main.class.getResource(name);
   if (resource == null) {
      throw new IllegalArgumentException(String.format("Error opening %s", name));
   }
   return IOUtils.toString(resource.openStream());
	}
}