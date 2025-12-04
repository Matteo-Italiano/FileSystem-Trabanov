package org.example;

import java.util.Date;

public abstract class Information implements Comparable<Information> {
    private String name;
    private float size;
    private Date createdAt;
    private Date modifiedAt;
    private Directory parentDirectory;
    private boolean isFavorite;

    public Information(String name, float size, Date createdAt, Date modifiedAt, Directory parentDirectory) {
        this.name = name;
        this.size = size;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.parentDirectory = parentDirectory;
        this.isFavorite = false;
    }

    @Override
    public int compareTo(Information other) {
        return this.name.compareTo(other.name);
    }


    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", parentDirectory=" + (parentDirectory != null ? parentDirectory.getName() : "null") +
                ", isFavorite=" + isFavorite +
                '}';
    }

    public boolean isFavorite() {
        return isFavorite;
    }
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
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
    public float getSize() {
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
