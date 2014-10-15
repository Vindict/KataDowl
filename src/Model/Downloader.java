package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Downloader
{

    public static URLConnection checkURL(String host){

        URL url = null;
        URLConnection connection = null;
        try {
            url = new URL(host);
            connection = url.openConnection();
            int fileLength = connection.getContentLength();

            if (fileLength == -1)
            {
                System.out.println("Invalide URL or file.");
                connection = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

	public static void getFile(String host) {
		InputStream input = null;
		FileOutputStream writeFile = null;

		try
		{
			URL url = new URL(host);
			URLConnection connection = checkURL(host);
			int fileLength = connection.getContentLength();

			if (fileLength == -1)
			{
				System.out.println("Invalide URL or file.");
				return;
			}


			input = connection.getInputStream();
			String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
			writeFile = new FileOutputStream(fileName);
			byte[] buffer = new byte[1024];
			int read;

			while ((read = input.read(buffer)) > 0)
				writeFile.write(buffer, 0, read);
			writeFile.flush();
		}
		catch (IOException e)
		{
			System.out.println("Error while trying to download the file.");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writeFile.close();
				input.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}