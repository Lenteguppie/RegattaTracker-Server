import java.util.Scanner;
public class Roo
{
    public static final String NAME = "Roo";
    public static void main(String args[])
    {

        int c = 0;
        while (c < 150) {
            System.out.println(String.format("%s: %d",NAME, c));
            c++;
        }
    }

}