package com.RegattaTracker.modulemanager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Module implements Runnable{
    private Thread t;
    private String moduleName;
    private String folder =  ModuleManager.DIRPATH;
    private String PATH = "";
    private Process pro;
    private boolean stop_sig = false;

    public Module(String name){
        moduleName = name;
        PATH = folder + moduleName;

    }

    private void printLines(String name, InputStream ins) throws Exception
    {
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while ((line = in.readLine()) != null)
        {
            System.out.println(line);
        }
    }
    private int load(String command) throws Exception
    {
        pro = Runtime.getRuntime().exec(command);
        printLines(command, pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        return pro.exitValue();
    }

    @Override
    public void run() {

        System.out.println("Loading module: " + moduleName);
        try {
//                int k = load("javac " + PATH + ".jar");  // to run jar files use this line only!!!!

            int k = load("java -jar " + PATH + ".jar");
            int l = load("java -cp " + folder + " " + moduleName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        stop_sig = false;
        System.out.println(String.format("Module %s has stopped!", moduleName));
    }

    public void stop(){
        stop_sig = true;
        System.out.println(String.format("Module %s was forced to stop!", moduleName));
        if(t.isAlive()){

            t.interrupt();
        }else{
            System.out.println(String.format("Module %s was already stopped", moduleName));
        }

    }

    public void start(){
        System.out.print("Starting " +  moduleName );
        System.out.println("@ " + PATH);
//        System.out.println(t.isInterrupted());
        while (stop_sig){

        }
        if (t == null) {
            t = new Thread (this, moduleName);
            t.start ();
        }else{
            System.out.println("somethings wrong I can feel it");
            System.out.println(t.getState());
        }

    }
}
