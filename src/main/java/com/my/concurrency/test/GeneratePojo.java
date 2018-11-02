package com.my.concurrency.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratePojo {
    public static void main(String[] args) throws InvalidConfigurationException, InterruptedException, SQLException, IOException, XMLParserException {
        String rootDir = System.getProperty("user.dir");

        if (false) {
            String absolutePath = new File(".").getAbsolutePath();
            System.out.println(absolutePath);
            System.out.println("Working Directory = " +
                    "\\src\\main\\resources\\mbg.xml");
        } else {

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File(rootDir + "\\src\\main\\resources\\mbg.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }


    }
}
