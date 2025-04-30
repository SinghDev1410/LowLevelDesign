package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.CompositeDp;

import java.util.ArrayList;
import java.util.List;

public class CompositeDp {
    public static void main(String[] args) {

        Directory movieDirectory = new Directory("Movie");
        FilesSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        File dhamaal = new File("Dhamaal");
        comedyMovieDirectory.add(hulchul);
        comedyMovieDirectory.add(dhamaal);

        movieDirectory.ls();
        comedyMovieDirectory.ls();

    }
}

interface FilesSystem {
    public void ls();
}

class  File implements FilesSystem {
    String fileName;

    File(String name){
        this.fileName = name;
    }
    @Override
    public void ls() {
        System.out.println("file name " + fileName);
    }
}

class Directory implements FilesSystem {

    String directoryName;
    List<FilesSystem> filesSystemsList;

    public Directory(String name){
        this.directoryName = name;
        filesSystemsList = new ArrayList<>();
    }

    public void add(FilesSystem filesSystem){
        filesSystemsList.add(filesSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name " + directoryName);

        for (FilesSystem filesSystem : filesSystemsList){
            filesSystem.ls();
        }
    }
}