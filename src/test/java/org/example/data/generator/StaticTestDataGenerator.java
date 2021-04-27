package org.example.data.generator;

public class StaticTestDataGenerator implements TestDataGenerator {

    @Override
    public String getProjectName() {
        return "Static project name";
    }

    @Override
    public String getTaskContent() {
        return "Static task content";
    }

    @Override
    public boolean isTypeOf(String type) {
        return "static".equals(type);
    }
}
