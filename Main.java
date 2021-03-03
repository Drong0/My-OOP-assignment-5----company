package com.company;

import com.company.data.IDB;
import com.company.data.PostgreDB;
import com.company.Interfaces.Interfaces;

public class Main {
    public static void main(String[] args) {
        IDB db =new PostgreDB();
        Interfaces repo=new Repositories(db);
        Controller controller= new Controller(repo);
        App app=new App(controller);
        app.start();

    }
}
