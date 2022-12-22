package com.lockin.lockedme.displays;

import com.lockin.lockedme.items.StoreArea;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileMenuDisplay implements Display {
    private StoreArea dir = new StoreArea();

    private ArrayList<String> menu = new ArrayList<>();

    public FileMenuDisplay() {

        menu.add("1]. ADD A NEW FILE\n");
        menu.add("2]. DELETE AN EXISTING FILE\n");
        menu.add("3]. SEARCH FOR A FILE BY ITS NAME\n");
        menu.add("4]. RETURN TO DASHBOARD");

    }

    @Override
    public void Show() {
        System.out.println("\nFILE OPERATIONS\n");
        for (String s : menu) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {

        switch(option) {

            case 1: // Add File
                this.AddFile();

                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();

                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;

            default:
                System.out.println("OOPS! OPTION NOT AVAILABLE, PLEASE TRY ANOTHER ONE");
                break;


        }

    }

    //TODO: Add functionality to all

    // Finished TODO

    public void AddFile() {
        System.out.println("ENTER THE FILE NAME TO BE ADDED :- ");

        String item = this.getInputString();

       // System.out.println("SURE YOU WANT TO ADD " + item + " ?");

        try {
            Path path = FileSystems.getDefault().getPath(StoreArea.name + item).toAbsolutePath();
            File file = new File(dir.getName() + item);

            if (file.createNewFile()) {
                System.out.println("NEW FILE CREATED AS :- " + file.getName());
                dir.getFiles().add(file);

            } else {
                System.out.println("AH SWAP! FILE ALREADY EXIST");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }



    public void DeleteFile() {

        System.out.println("ENTER THE FILE NAME TO BE DLETED :- ");

        String item = this.getInputString();

//        System.out.println("SURE YOU WANT TO DELETE : " + item +" ?");


        //TODO: Delete file
        // Finished TODO

        Path path = FileSystems.getDefault().getPath(StoreArea.name + item).toAbsolutePath();
        File file_path = path.toFile();
        if (file_path.delete()) {
            System.out.println("DELETED FILE NAME :- " + file_path.getName());
            dir.getFiles().remove(file_path);
        } else {
            System.out.println("OOPS! OPERATION NOT POSSIBLE. " + item + " DOESN'T EXISTS");
        }
    }

    public void SearchFile() {

        Boolean found = false;

        System.out.println("WHICH FILE DO YOU WANT? PLEASE ENTER ITS NAME HERE :- ");

        String item = this.getInputString();

        //System.out.println("YOU LOOKED FOR :- " + item);

        //TODO Fix it so ArrayList obtains files
        //Finished TODO

        ArrayList<File> all_files = dir.getFiles();


        for(int i = 0; i < all_files.size(); i++) {
            if(all_files.get(i).getName().equals(item)) {
                System.out.println("HERE's YOUR FILE :- " + item);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("SORRY! FILE NOT FOUND");
        }
    }

    private String getInputString() {

        Scanner sc = new Scanner(System.in);
        return(sc.nextLine());

    }

    private int getOption() {
        Scanner sc = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = sc.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("OOPS! INVALID INPUT");
        }
        return returnOption;

    }
}
