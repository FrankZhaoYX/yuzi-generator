package com.frank.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Static file generation
 */
public class StaticGenerator {

    /**
     * Copy files (Hutool implementation, copies the entire input directory into the output directory)
     *
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void main(String[] args) {
        // Get the root path of the entire project
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // Input path: ACM sample code template directory
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        // Output path: directly output to the project root directory
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * Copy files recursively (recursive implementation, copies the entire input directory into the output directory)
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("File copy failed");
            e.printStackTrace();
        }
    }

    /**
     * File A => Directory B: File A is placed under Directory B
     * File A => File B: File A overwrites File B
     * Directory A => Directory B: Directory A is placed under Directory B
     *
     * Core approach: create the directory first, then traverse and copy files one by one
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // Distinguish between file and directory
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // If it's a directory, create the target directory first
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // Get all files and subdirectories in the directory
            File[] files = inputFile.listFiles();
            // No child files, return immediately
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // Recursively copy the next level of files
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // It's a file, copy it directly to the target directory
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
