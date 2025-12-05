package org.example;
import java.util.Date;

public class File extends Information {
    public File(String name, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        super(name, Math.random() * 10, createdAt, modifiedAt, parentDirectory);
    }
}
