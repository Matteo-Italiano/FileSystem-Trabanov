package org.example;

import java.util.Date;

public abstract class Information implements Comparable<Information> {
    private String name;
    private double size;
    private Date createdAt;
    private Date modifiedAt;
    private Directory parentDirectory;

    public Information(String name, double size, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        this.name = name;
        this.size = size;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.parentDirectory = parentDirectory;
    }

    @Override
    public int compareTo(Information other) {
        if(this.getSize() == other.getSize()) return 0;
        else if(this.getSize() < other.getSize()) return -1;
        else return 1;
    }


    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", parentDirectory=" + (parentDirectory != null ? parentDirectory.getName() : "null") +
                '}';
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }
    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }
    public Date getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public double getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
