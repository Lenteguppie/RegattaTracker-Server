import java.util.Scanner;
public class Foo
{
    public static final String NAME = "Foo";
    public static void main(String args[])
    {
        int c = 0;
        while (c < 130) {
            System.out.println(String.format("%s: %d",NAME, c));
            c++;
        }
    }

}