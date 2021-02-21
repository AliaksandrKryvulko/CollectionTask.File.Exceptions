package JavaIoFile;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class FileClassWorkingBetacodeManual {
    public static void main(String[] args) {
        //Read byte stream
        FileInputStream input = null;
        int code = 0;
        try {
            input = new FileInputStream("data/info.txt");
            code = input.read();//will be reade 1 symbol
            System.out.println(code + "  convert to symbol its=>" + (char) code);// showed his code
            byte[] array = new byte[40];
            int countReadeByte = input.read(array);
            System.out.println("count reade byte - " + countReadeByte);
            System.out.println(Arrays.toString(array));//shows all symbol of code what was been reade
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /////////////////////////////////
        System.out.println("-------------------Checking existing file----------------------");
        File apath = new File("d:\\testingdir\\stringa.txt");
        //Checking existing file
        System.out.println("Exist or Not: " + apath.exists());
        if (apath.exists()) {
            System.out.println("Check this is directory:=> " + apath.isDirectory());
            System.out.println("Get Simple name: " + apath.getName());
            System.out.println("Get absolute path: " + apath.getAbsolutePath());
            System.out.println("Get byte count whithout whitespaces: " + apath.length());
            long lastModMillis = apath.lastModified();
            Date lastModDate = new Date(lastModMillis);
            System.out.println("Last modified date: " + lastModDate);
        }

        //Creating Catalog
        System.out.println("----------------------Creating Catalog---------------------------");
        File dir1 = new File("d:\\TemporaryCatalog\\Temp1");
        System.out.println("Get absolute path: " + dir1);
        System.out.println("Dir exist? "+dir1.exists());
        System.out.println("Parent file exist? "+dir1.getParentFile().exists());
        boolean created=dir1.mkdirs();//
        System.out.println("Directrory created? " + created);
        System.out.println("------------------ListRoot--------------------");
        File[] rootz= File.listRoots();
        for (File root:rootz){
            System.out.println(root);
        }

        //Filter
        System.out.println("--------------------Filter---------------------");
        File dir= new File("d:\\testingdir");
        File [] children= dir.listFiles();//return all folders from the current folder, but without inserted folder and files
        for (File file:children){
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------------------------");
        String [] paths= dir.list();//return name of folders
        for (String p:paths){
            System.out.println(p);
        }
        File dir2= new File("data");
        File [] txtFile=dir2.listFiles(new TxtFileFilter());
        for (File txt:txtFile){
            System.out.println("Showing AbsolutePath with *.txt extension:=>  "+txt.getAbsolutePath());//Do not finding txt in subfolders
        }

        ///////////RecursiveFileExample///////////
        System.out.println("************RecursiveFileExample*************");
        RecursiveFileExample rfe=new RecursiveFileExample();
        File dir3=new File("d:\\TestingDir");
        rfe.fetchChild(dir3);

        //Rename File

        System.out.println("------------------Rename File----------------");
        //Source file
        File srcFile=new File("d:\\TestingDir\\juk\\niama.txt");
        //Destination File
        File destFile=new File("D:\\TestingDir\\NewFolder\\ReformatedInfo.txt");
        if (!srcFile.exists()){
            System.out.println("Src file does't exist ");
            return;
        }
        destFile.getParentFile().mkdirs();
        boolean renamed=srcFile.renameTo(destFile);
        System.out.println("File changed=> "+renamed);
    }
}
