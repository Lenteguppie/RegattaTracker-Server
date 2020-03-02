/**
 *Functions printLines, Run, and parts of main came from stacks overflow
 *originaly but modifications have been made
 *http://stackoverflow.com/questions/4842684/how-to-compile-run-java-program-in-another-java-program
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.RegattaTracker.modulemanager.ModuleManager;

public class RegattaTracker
{
   public static void main(String args[])
    {
//        String[] modules = {"Foo", "Poo", "Roo"};  // test for separate java classes
        String[] modules = {"Foo"}; //test for jar file
        ModuleManager moduleManager = new ModuleManager(modules);
//        moduleManager.unload_module("Foo");
    }
}