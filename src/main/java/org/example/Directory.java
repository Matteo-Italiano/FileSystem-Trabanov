package org.example;

import java.util.Date;
import java.util.List;

public class Directory extends Information {
    List<File> files;
    List<Directory> directories;

    public Directory(String name, float size, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        super(name, size, createdAt, modifiedAt, parentDirectory);
    }

    public void createFile(String name, float size){
        File newFile = new File(name, size, new Date(), null, this);
        files.add(newFile);
    }

    public void createDirectory(String name, float size){
        Directory newDirectory = new Directory(name, size, new Date(), null, this);
        directories.add(newDirectory);
    }

    public void removeDirectory(String name, float size){
        directories.removeIf(directory -> directory.getName().equals(name));
    }

    public void removeFile(String name){
        files.removeIf(file -> file.getName().equals(name));
    }

    @Override
    public String toString() {
        return "Directory{" +
                "files=" + files.size() +
                ", directories=" + directories.size() +
                "} " + super.toString();
    }

}
