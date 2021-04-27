package org.example.data.generator;

import com.github.javafaker.Faker;

public class RandomTestDataGenerator implements TestDataGenerator {

    private static final Faker generator = new Faker();

    @Override
    public String getProjectName() {
        return generator.beer().name();
    }

    @Override
    public String getTaskContent() {
        return generator.gameOfThrones().quote();
    }

    @Override
    public boolean isTypeOf(String type) {
        return "random".equals(type);
    }
}
