package org.example;

public class File extends Information {
    public File(String name, float size, java.util.Date createdAt, java.util.Date modifiedAt, Directory parentDirectory) {
        super(name, size, createdAt, modifiedAt, parentDirectory);
    }
}
