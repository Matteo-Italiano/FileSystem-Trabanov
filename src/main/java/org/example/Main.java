package org.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Directory rootDirectory = new Directory("Starter", new Date(), new Date(), null);
        Directory currentDirectory = rootDirectory;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File System Simulator!");
        System.out.println("Type Help to see the options \n");

        while (true) {
            String Option = scanner.nextLine();
            String[] parts = Option.split(" ");

            switch (parts[0]) {
                case "mkdir":
                    if (parts.length > 1) {
                        System.out.println("Please enter the correct command without additional arguments. \n");
                        break;
                    }
                    System.out.print("Enter directory name: ");
                    String dirName = scanner.nextLine();
                    currentDirectory.createDirectory(dirName);
                    System.out.println("Directory '" + dirName + "' created successfully. \n");
                    break;
                case "touch":
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    try {
                        currentDirectory.createFile(fileName);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage() + "\n");
                        break;
                    }
                    System.out.println("File '" + fileName + "' created successfully. \n");
                    break;
                case "exit":
                    System.out.println("Exiting the File System Simulator. Goodbye! \n");
                    scanner.close();
                    return;
                case "ls":
                    System.out.println("Files: ");
                    currentDirectory.getFiles().forEach(file -> {
                        System.out.println(file.getName() + "(" + file.getSize() + " MB)");
                    });
                    System.out.println("\n");

                    System.out.println("Directorys: ");
                    currentDirectory.getDirectories().forEach(dir -> {
                        System.out.println(dir.getName());
                    });
                    System.out.println("\n");
                    break;
                case "cd":
                    if (parts.length != 2) {
                        System.out.println("Please provide a directory name to change to. \n");
                        break;
                    }
                    String targetDirName = parts[1];

                    if (targetDirName.equals("..")) {
                        if (currentDirectory.getParentDirectory() != null) {
                            currentDirectory = currentDirectory.getParentDirectory();
                            System.out.println("Moved to parent directory: " + currentDirectory.getName() + "\n");
                        } else {
                            System.out.println("Already at the root directory. \n");
                        }
                        break;
                    }

                    if (targetDirName.equals("/")) {
                        currentDirectory = rootDirectory;
                        System.out.println("Moved to root directory.\n");
                        break;
                    }

                    List<Directory> directories = currentDirectory.getDirectories();
                    boolean found = false;
                    for (Directory dir : directories) {
                        if (dir.getName().equals(targetDirName)) {
                            currentDirectory = dir;
                            System.out.println("Changed current directory to: " + currentDirectory.getName() + "\n");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Directory '" + targetDirName + "' not found. \n");
                    }
                    break;

                case "pwd":
                    System.out.println("Current path: " + currentDirectory.getPath() + "\n");
                    break;

                case "rm":
                    if (parts.length < 2) {
                        System.out.println("Please provide a file name to remove. \n");
                        break;
                    }
                    String targetFileName = parts[1];
                    currentDirectory.removeFile(targetFileName);
                    System.out.println("File '" + targetFileName + "' removed successfully. \n");
                    break;

                case  "rmdir":
                    if (parts.length < 2) {
                        System.out.println("Please provide a directory name to remove. \n");
                        break;
                    }
                    String targetDirectoryName = parts[1];
                    currentDirectory.removeDirectory(targetDirectoryName);
                    System.out.println("Directory '" + targetDirectoryName + "' removed successfully. \n");
                    break;
                case "sort":
                    currentDirectory.sortFiles();
                    System.out.println("Files sorted by size successfully. \n");
                    break;
                case "Help":
                    System.out.println("<mkdir> Create a new directory");
                    System.out.println("<touch> Create a new file");
                    System.out.println("<exit> End System");
                    System.out.println("<ls> to list files and directories");
                    System.out.println("<cd directory_name> to change directory");
                    System.out.println("<rm> to delete a file");
                    System.out.println("<rmdir> to delete a directory");
                    System.out.println("<pwd> to show current path ");
                    System.out.println("Type Help to see the options \n");
                    break;
                default:
                    System.out.println("Invalid option. Please try again. \n");
                    break;
            }
        }
    }
}