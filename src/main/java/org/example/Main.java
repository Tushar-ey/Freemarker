package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, TemplateException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

        // Set the directory where the template files are located
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        cfg.setDefaultEncoding("UTF-8");

        // Load the template
        Template template = cfg.getTemplate("template.ftl");

        // Create a data model (map) with data to populate the template
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "Tushar");
        dataModel.put("message","Welcome to the MB UCars Website!");


        // Merge data model with the template and output to a file
        try (FileWriter out = new FileWriter(new File("output.html"))) {
            template.process(dataModel, out);
        }

        System.out.println("Template processed successfully. Check the output.html file.");

        }
    }
