package JavaIoFile;

import java.io.File;
import java.io.FileFilter;

public class RecursiveFileExample {
    public void fetchChild (File file){
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()){
            File [] children=file.listFiles();
            for (File child:children){
                this.fetchChild(child);
            }
        }
    }
}
