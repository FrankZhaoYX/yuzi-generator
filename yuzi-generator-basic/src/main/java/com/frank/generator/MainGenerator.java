package com.frank.generator;

import java.io.File;
import java.io.IOException;

import com.frank.model.MainTemplateConfig;
import freemarker.template.TemplateException;

public class MainGenerator {
    public static void main(String[] args) throws IOException, TemplateException {

        // Static file generation
        // Get the root path of the entire project
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // Input path: ACM sample code template directory
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        // Output path: directly output to the project root directory
        String outputPath = projectPath;
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        // Dynamic file generation
        String dynamic_inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamic_outputPath = projectPath + File.separator + "yuzi-generator-demo-projects/acm-template/src/com/frank/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(dynamic_inputPath, dynamic_outputPath, mainTemplateConfig);
    }
}
