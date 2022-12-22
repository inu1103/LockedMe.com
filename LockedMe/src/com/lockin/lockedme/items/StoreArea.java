package com.lockin.lockedme.items;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class StoreArea {
    public static final String name = "src/filehouse/";

    //TODO: Possibly use a HashMap? Too complex for now.
    private ArrayList<File> files = new ArrayList<File>();

    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();

    File stored_files = path.toFile();

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("EXISTING FILES :- ");
        files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles() {

        File[] directoryFiles = stored_files.listFiles();



        files.clear();
        for (int i = 0; i < directoryFiles.length; i++) {
            if (directoryFiles[i].isFile()) {
                files.add(directoryFiles[i]);
            }
        }

        Collections.sort(files);

        return files;
    }

    public ArrayList<File> getFiles() {

        fillFiles();
        return files;
    }


    public void mergeSort() {

    }
}
