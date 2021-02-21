package JavaIo;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TrainyPath {
    public static void main(String[] args) throws IOException {
        //creating File
        Path testFile1=null;
        try {
            testFile1= Files. createFile(Paths.get("D:\\Stringa.txt"));
        }
        catch (FileAlreadyExistsException aee){
            System.err.println("This file alredy exist");
        }
        System.out.println(testFile1);
        System.out.println("Will be create directory? "+Files.exists(Paths.get("D:\\Stringa.txt")));
        //creating Directory
        Path testDir=null;
        try {
            testDir=Files.createDirectory(Paths.get("d:\\TestingDir"));
        }
        catch (FileAlreadyExistsException aee){
            System.err.println("This directory already exist");
        }
        System.out.println("Will be created this dir?");
        System.out.println(Files.exists(Paths.get("d:\\TestingDir")));
        //System.out.println(Files.exists(testDir)); Drop Down whith NPE

        //moving file to another directory
        testFile1= Files.move(testFile1, Paths.get("d:\\TestingDir\\Stringa.txt"));
        //Deleting File
        Files.delete(testFile1);
        System.out.println(Files.exists(Paths.get("d:\\TestingDir\\Stringa.txt")));
        //Copy--

    }
}
