/**
 * 
 * @author Hyunkun Cho
 */
package config;
import java.io.*;

public class saveFile {
    public static void main(String[] args) throws IOException{
        File file = new File("file.cfg");
        FileOutputStream fileOut = new FileOutputStream(file);
        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fileOut));

        for(int i = 0; i < 10; i++){
            buffer.newLine();
        }
        buffer.close();
    }
    public static void saveAsCfg(String i, File f) throws IOException{
        if (!f.getAbsolutePath().contains(".cjg")){
            f = new File(f.getAbsolutePath() + ".cfg");
        }
        FileOutputStream fileOut = new FileOutputStream(f);
        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fileOut));
        buffer.write(i);
        buffer.close();

    }
}