package org.example.data.restapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectResponse {
    private long id;
    private int order;
    private int color;
    private String name;
}
