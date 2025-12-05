package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory extends Information {
    private List<File> files;
    private List<Directory> directories;

    public Directory(String name, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        super(name, Math.random(), createdAt, modifiedAt, parentDirectory);
        files = new ArrayList<>();
        directories = new ArrayList<>();
    }

    public void createFile(String name) throws Exception {
        for (File file : files) {
            if (file.getName().equals(name)) {
                throw new Exception("File with the same name already exists.");
            }
        }
        File newFile = new File(name, new Date(), null, this);
        files.add(newFile);
    }

    public void createDirectory(String name){
        Directory newDirectory = new Directory(name, new Date(), null, this);
        directories.add(newDirectory);
    }

    public void sortFiles(){
        files.sort(Information::compareTo);
    }

    public void removeDirectory(String name, float size){
        directories.removeIf(directory -> directory.getName().equals(name));
    }

    public void removeFile(String name){
        files.removeIf(file -> file.getName().equals(name));
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public String getPath(){
        if(getParentDirectory() == null){
            return "/";
        } else {
            return getParentDirectory().getPath() + getName() + "/";
        }
    }

    @Override
    public String toString() {
        return "Directory{" +
                "files=" + files.size() +
                ", directories=" + directories.size() +
                "} " + super.toString();
    }
}
