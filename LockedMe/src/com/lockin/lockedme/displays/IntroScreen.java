package com.lockin.lockedme.displays;

import com.lockin.lockedme.services.StoreAreaService;
import com.lockin.lockedme.services.DisplayService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntroScreen implements Display{
    private String title = "\n                            LOCKEDME                                 \n";
    private String tag_line = "                                -A One Stop Solution to all of your files";

    private String upper_border = "-------------------------------------------------------------------------";
    private String lower_border = "-------------------------------------------------------------------------";
    private String author = "Developed By : Ishan Lahoti";
    private ArrayList<String> menu = new ArrayList<>();


    public IntroScreen() {
        menu.add("1]. DISPLAY ALL FILES\n");
        menu.add("2]. GET ON TO FILE OPERATIONS MENU\n");
        menu.add("3]. *EXIT*\n");

    }

    public void introWS() {
        System.out.println(upper_border);
        System.out.println(title);
        System.out.println(tag_line);
        System.out.println(lower_border);
        System.out.println();
        System.out.println(author);
        System.out.println("\n");
        Show();
    }



    @Override
    public void Show() {
        System.out.println("WELCOME TO DASHBOARD !\n");
        for (String s : menu)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();

                this.Show();

                break;

            case 2: // Show File Options menu
                DisplayService.setCurrentScreen(DisplayService.FileMenuDisplay);
                DisplayService.getCurrentScreen().Show();
                DisplayService.getCurrentScreen().GetUserInput();

                this.Show();

                break;

            default:
                System.out.println("OOPS! INVALID OPTION");
                break;
        }

    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory

        //Finished TODO Task

        System.out.println("HERE ARE YOUR STORED FILES :-  ");
        StoreAreaService.PrintFiles();

    }

    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
