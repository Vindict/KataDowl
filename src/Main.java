import Model.Debrider;
import Model.Downloader;

/**
 * Created by vbrice on 10/14/14.
 */
public class Main {

    public static void main(String[] args){
        Debrider debrider = new Debrider("http://uptobox.com/1jlnofrds2tm");
        debrider.execDeb();
        Downloader downloader = new Downloader(debrider.getLink());
        downloader.execDown();
        System.out.println(downloader.getLink());
    }


}
