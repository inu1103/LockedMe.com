package com.lockin.lockedme.services;

import java.io.File;

import com.lockin.lockedme.items.StoreArea;
public class StoreAreaService {
    private static StoreArea fileDirectory = new StoreArea();

    public static void PrintFiles() {

        fileDirectory.fillFiles();

        for (File file : StoreAreaService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static StoreArea getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(StoreArea fileDirectory) {
        StoreAreaService.fileDirectory = fileDirectory;
    }

}
