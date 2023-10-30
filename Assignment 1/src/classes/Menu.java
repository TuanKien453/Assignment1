package classes;

import java.util.*;

public class Menu {

    public static int getChoice(Object[] option) {
        int i = 0;
        for (Object object : option) {
            i++;
            System.out.println(object);
        }

        int choice = Inputer.menuChoice("Choose 1.." + option.length+"\n", 1, option.length);

        return choice;
    }
}
