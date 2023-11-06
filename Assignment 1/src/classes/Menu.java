package classes;

import java.util.*;

public class Menu {
    //DEV by Hoàng Tuấn Kiên 
    public static int getChoice(Object[] option) {
        int i = 0;
        for (Object object : option) {
            i++;
            System.out.println(i + "-" + object);
        }

        int choice = Inputer.menuChoice("Choose 1.." + option.length+"\n", 1, option.length);

        return choice;
    }
    //DEV by Nguyễn Thanh Khuê
    public static Object ref_getChoice(ArrayList<Object> option){

       Object[] brandarr = option.toArray();
       int choice = getChoice(brandarr);
       return option.get(choice-1);
    }
}
