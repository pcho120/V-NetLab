/**
 *
 * @author Hyunkun Cho
 */
package config;

import java.io.File;

public class configFile extends javax.swing.filechooser.FileFilter{

    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".cfg");
    }

    public String getDescription() {
        return "Config files .cfg";
    }
}