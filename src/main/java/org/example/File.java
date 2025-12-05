package org.example;
import java.util.Date;

public class File extends Information {
    private String type;

    public File(String name, double size, Date createdAt, Date modifiedAt, Directory parentDirectory, String type) {
        super(name, size, createdAt, modifiedAt, parentDirectory);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void changeType(String type){
        this.type = type;
    }
}
