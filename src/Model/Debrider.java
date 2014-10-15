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

    public String execDeb(){

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

        return undebridLink;
    }

    public String execDeb(String host){

        Runtime runtime = Runtime.getRuntime();
        String cmd = "/home/vbrice/debrid/undebrid.sh " + host;
        String undebridLink="";
        try {
            InputStream inputStream = runtime.exec(cmd).getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String uL = "";
            while (null != (uL= bufferedReader.readLine())){
                undebridLink = undebridLink.concat(uL);
            }


            this.setRes(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return undebridLink;
    }

    public String[] execDebByFile(String path) throws IOException {
        String ligne = "";
        String fichier = path;
        BufferedReader ficTexte;
        try {
            ficTexte = new BufferedReader(new FileReader(new File(fichier)));
            if (ficTexte == null) {
                throw new FileNotFoundException("Fichier non trouvé: "
                        + fichier);
            }
            do {
                ligne = ficTexte.readLine();
                if (ligne != null) {
                    System.out.println(execDeb(ligne));
                }
            } while (ficTexte != null);
            ficTexte.close();
            System.out.println("\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}
