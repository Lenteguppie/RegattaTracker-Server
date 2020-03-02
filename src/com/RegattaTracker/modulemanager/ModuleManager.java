package com.RegattaTracker.modulemanager;

import java.util.Hashtable;

public class ModuleManager {
    public static final String DIRPATH = "modules/";
    Hashtable<String, Module> modules = new Hashtable<>();

    public ModuleManager(String[] _modules){
        System.out.println("Preloading modules");
        preloadModules(_modules);
    }

    public ModuleManager(){
        System.out.println("Waiting for extentions to load...");
    }

    private void preloadModules(String[] modules_list){
        Module m;
        for (String name: modules_list) {
            m = new Module(name);
            modules.put(name, m);
            m.start();
        }
    }

    public void load_module(String name){
        System.out.println(String.format("Loading module: %s!", name));
        Module m = modules.get(name);
        m.start();
    }

    public void unload_module(String name){
        System.out.println(String.format("Unloading module: %s!", name));
        Module m = modules.get(name);
        m.stop();
    }
}
