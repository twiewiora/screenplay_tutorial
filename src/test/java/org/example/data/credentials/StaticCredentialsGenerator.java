package org.example.data.credentials;

import org.example.abilities.AuthoriseHimself;

public class StaticCredentialsGenerator implements CredentialsGenerator {

    @Override
    public AuthoriseHimself getAccount() {
        return new AuthoriseHimself("tidara9879@yehudabx.com", "haslo123", "Bearer ad5877db4d196bad0145b81caeb8e553057dd9c4");
    }
}
