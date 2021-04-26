package org.example.data.credentials;

import org.example.abilities.AuthoriseHimself;

public class StaticCredentialsGenerator implements CredentialsGenerator {

    @Override
    public AuthoriseHimself getAccount() {
        return new AuthoriseHimself("tidara9879@yehudabx.com", "haslo123");
    }
}
