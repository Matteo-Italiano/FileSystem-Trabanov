package org.example;
import java.util.Date;

public class File extends Information {
    public File(String name, float size, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        super(name, size, createdAt, modifiedAt, parentDirectory);
    }
}
