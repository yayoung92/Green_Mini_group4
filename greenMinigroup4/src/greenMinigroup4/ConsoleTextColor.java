package greenMinigroup4;

public class ConsoleTextColor {
    public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36m" ;
    public static final String white     = "\u001B[37m" ;
    public static final String exit     = "\u001B[0m" ;

    public static void printColorln(String massge, String color){
        if     ("Black".equals(color) || "black".equals(color))         color = black;
        else if("Red".equals(color) || "red".equals(color))             color = red;
        else if("Green".equals(color) || "green".equals(color))         color = green;
        else if("Yellow".equals(color) || "yellow".equals(color))       color = yellow;
        else if("Blue".equals(color) || "blue".equals(color))           color = blue;
        else if("Purple".equals(color) || "purple".equals(color))       color = purple;
        else if("Cyan".equals(color) || "cyan".equals(color))           color = cyan;
        else color = white;


        System.out.println(color+massge);
        System.out.print("\u001B[0m");
    }
//    
//    public static void printColor(String massge, String color){
//        if     ("Black".equals(color) || "black".equals(color))         color = black;
//        else if("Red".equals(color) || "red".equals(color))             color = red;
//        else if("Green".equals(color) || "green".equals(color))         color = green;
//        else if("Yellow".equals(color) || "yellow".equals(color))       color = yellow;
//        else if("Blue".equals(color) || "blue".equals(color))           color = blue;
//        else if("Purple".equals(color) || "purple".equals(color))       color = purple;
//        else if("Cyan".equals(color) || "cyan".equals(color))           color = cyan;
//        else color = white;
//
//
//        System.out.print(color+massge);
//        System.out.print("\u001B[0m");
//    }
    
    public void resetColor(){
        System.out.print("\u001B[0m");
    }
}
