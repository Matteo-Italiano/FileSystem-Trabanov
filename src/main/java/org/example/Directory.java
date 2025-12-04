package org.example;

import java.util.Date;

public class Directory extends Information {
    public Directory(String name, float size, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        super(name, size, createdAt, modifiedAt, parentDirectory);
    }

}
