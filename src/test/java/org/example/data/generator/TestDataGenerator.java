package org.example.data.generator;

public interface TestDataGenerator {

    String getProjectName();

    String getTaskContent();

    boolean isTypeOf(String type);
}
