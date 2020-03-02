import java.util.Scanner;
public class Poo
{
    public static final String NAME = "Poo";
    public static void main(String args[])
    {
        int c = 0;
        while (c < 100) {
            System.out.println(String.format("%s: %d",NAME, c));
            c++;
        }
    }

}