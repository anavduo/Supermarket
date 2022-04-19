package entity;

import service.IPrint;

public class Printer {
    public void print(IPrint print){
        print.print("Hello world!");
    }
}
