import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHandler {

	
	public void integrateFiles (String input_folder, String output_file) throws IOException
	{
		
		final File folder = new File(input_folder);
		FileOutputStream fostream = new FileOutputStream(output_file);
		DataOutputStream out = new DataOutputStream(fostream);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	    for (final File fileEntry : folder.listFiles()) {
	    	
	    	String path = fileEntry.getAbsolutePath();
	    	FileInputStream instream = new FileInputStream(path);
	    	DataInputStream in = new DataInputStream(instream);
	    	BufferedReader  r = new BufferedReader(new InputStreamReader(in));
	    	
	    	for(String l = r.readLine(); l != null; l=r.readLine())
	    	{
	    		writer.write(l+"\n");
	    	}
	    	
	    }writer.close();
	}
	
	public static void main (String args[]) throws IOException
	{
		FileHandler fh = new FileHandler();
		fh.integrateFiles("C:\\workspace_git\\MovieCrawler\\data\\DataUsingCrawler","C:\\workspace_git\\MovieCrawler\\data\\DataUsingCrawler\\2011to20170731.txt");
	}
}
