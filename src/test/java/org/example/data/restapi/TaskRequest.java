package org.example.data.restapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequest {
    private String content;
    private long project_id;
}
