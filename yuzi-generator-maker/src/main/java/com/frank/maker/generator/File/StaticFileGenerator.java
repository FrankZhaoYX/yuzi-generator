package com.frank.maker.generator.File;

import cn.hutool.core.io.FileUtil;
/**
 * Static file generation
 */
public class StaticFileGenerator {

    /**
     * Copy files (Hutool implementation, copies the entire input directory into the output directory)
     *
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

}
