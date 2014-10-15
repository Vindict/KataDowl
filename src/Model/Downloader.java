package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vbrice on 10/14/14.
 */
public class Downloader {

    int res;
    String link;

    public Downloader(String link) {
        this.link = link;
    }

    public Downloader(){

    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void execDown(){

        Runtime runtime = Runtime.getRuntime();
        String cmd = "wget " + link;
        String trace="";
        try {
            InputStream inputStream = runtime.exec(cmd).getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String uL = "";
            while (null != (uL= bufferedReader.readLine())){
                trace = trace.concat(uL);
                System.out.println(trace);
            }

            this.setLink(trace);
            this.setRes(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
