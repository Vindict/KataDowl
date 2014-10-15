package Model;

import java.io.*;

/**
 * Created by vbrice on 10/14/14.
 */
public class Debrider {

    int res;
    String link;

    public Debrider(String link) {
        this.link = link;
    }

    public Debrider(){

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

    public void execDeb(){

        Runtime runtime = Runtime.getRuntime();
        String cmd = "/home/vbrice/debrid/undebrid.sh " + link;
        String undebridLink="";
        try {
            InputStream inputStream = runtime.exec(cmd).getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String uL = "";
            while (null != (uL= bufferedReader.readLine())){
                undebridLink = undebridLink.concat(uL);
            }

            this.setLink(undebridLink);
            this.setRes(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
