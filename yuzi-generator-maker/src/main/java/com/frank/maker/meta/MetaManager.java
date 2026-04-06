package com.frank.maker.meta;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

import java.util.List;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager() {
        // 私有构造函数，防止外部实例化
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        validAndFill(newMeta);
        return newMeta;
    }

    private static void validAndFill(Meta meta) {
        // validate required top-level fields
        if (StrUtil.isBlank(meta.getName())) {
            throw new RuntimeException("meta.name is required");
        }

        // FileConfig validation and defaults
        Meta.FileConfig fileConfig = meta.getFileConfig();
        if (fileConfig == null) {
            throw new RuntimeException("meta.fileConfig is required");
        }
        if (StrUtil.isBlank(fileConfig.getInputRootPath())) {
            throw new RuntimeException("fileConfig.inputRootPath is required");
        }
        if (StrUtil.isBlank(fileConfig.getOutputRootPath())) {
            fileConfig.setOutputRootPath("generated");
        }
        if (StrUtil.isBlank(fileConfig.getType())) {
            fileConfig.setType("dir");
        }

        List<Meta.FileItem> files = fileConfig.getFiles();
        if (CollUtil.isEmpty(files)) {
            throw new RuntimeException("fileConfig.files must not be empty");
        }
        for (Meta.FileItem fileItem : files) {
            if (StrUtil.isBlank(fileItem.getInputPath())) {
                throw new RuntimeException("fileItem.inputPath is required");
            }
            if (StrUtil.isBlank(fileItem.getOutputPath())) {
                fileItem.setOutputPath(fileItem.getInputPath());
            }
            if (StrUtil.isBlank(fileItem.getType())) {
                fileItem.setType("file");
            }
            if (StrUtil.isBlank(fileItem.getGenerateType())) {
                fileItem.setGenerateType("static");
            }
        }

        // ModelConfig validation and defaults
        Meta.ModelConfig modelConfig = meta.getModelConfig();
        if (modelConfig == null) {
            throw new RuntimeException("meta.modelConfig is required");
        }
        List<Meta.ModelItem> models = modelConfig.getModels();
        if (CollUtil.isEmpty(models)) {
            throw new RuntimeException("modelConfig.models must not be empty");
        }
        for (Meta.ModelItem modelItem : models) {
            if (StrUtil.isBlank(modelItem.getFieldName())) {
                throw new RuntimeException("modelItem.fieldName is required");
            }
            if (StrUtil.isBlank(modelItem.getType())) {
                modelItem.setType("String");
            }
        }
    }
}
