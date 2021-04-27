package org.example.data.restapi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProjectRequest {
    private final String name;
}