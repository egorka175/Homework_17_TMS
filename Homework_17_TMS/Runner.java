package com.tms.Homework_17_TMS;

public class Runner {
    public static void main(String[] args) {
        MetodsForCreatingTheFile newFile = new MetodsForCreatingTheFile();
        // DOM
        DOMParser parser = new DOMParser();
        parser.writeToFile(parser.process(newFile.pathValidation()));
    }
}



