package com.frank.maker.meta;

import java.util.List;

public class Meta {

    private String name;
    private String description;
    private String basePackage;
    private String version;
    private String author;
    private String createTime;
    private FileConfig fileConfig;
    private ModelConfig modelConfig;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public FileConfig getFileConfig() {
        return fileConfig;
    }

    public void setFileConfig(FileConfig fileConfig) {
        this.fileConfig = fileConfig;
    }

    public ModelConfig getModelConfig() {
        return modelConfig;
    }

    public void setModelConfig(ModelConfig modelConfig) {
        this.modelConfig = modelConfig;
    }

    public static class FileConfig {
        private String inputRootPath;
        private String outputRootPath;
        private String type;
        private List<FileItem> files;

        public String getInputRootPath() {
            return inputRootPath;
        }

        public void setInputRootPath(String inputRootPath) {
            this.inputRootPath = inputRootPath;
        }

        public String getOutputRootPath() {
            return outputRootPath;
        }

        public void setOutputRootPath(String outputRootPath) {
            this.outputRootPath = outputRootPath;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<FileItem> getFiles() {
            return files;
        }

        public void setFiles(List<FileItem> files) {
            this.files = files;
        }
    }

    public static class FileItem {
        private String inputPath;
        private String outputPath;
        private String type;
        private String generateType;

        public String getInputPath() {
            return inputPath;
        }

        public void setInputPath(String inputPath) {
            this.inputPath = inputPath;
        }

        public String getOutputPath() {
            return outputPath;
        }

        public void setOutputPath(String outputPath) {
            this.outputPath = outputPath;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getGenerateType() {
            return generateType;
        }

        public void setGenerateType(String generateType) {
            this.generateType = generateType;
        }
    }

    public static class ModelConfig {
        private List<ModelItem> models;

        public List<ModelItem> getModels() {
            return models;
        }

        public void setModels(List<ModelItem> models) {
            this.models = models;
        }
    }

    public static class ModelItem {
        private String fieldName;
        private String type;
        private String description;
        private Object defaultValue;
        private String abbr;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }
    }
}
