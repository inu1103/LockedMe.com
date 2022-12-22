package com.lockin.lockedme.services;

import com.lockin.lockedme.displays.FileMenuDisplay;
import com.lockin.lockedme.displays.Display;
import com.lockin.lockedme.displays.IntroScreen;


public class DisplayService {
    public static IntroScreen IntroScreen = new IntroScreen();
    public static com.lockin.lockedme.displays.FileMenuDisplay FileMenuDisplay = new FileMenuDisplay();



    public static Display CurrentScreen = IntroScreen;


    public static Display getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(Display currentScreen) {
        CurrentScreen = currentScreen;
    }

}
