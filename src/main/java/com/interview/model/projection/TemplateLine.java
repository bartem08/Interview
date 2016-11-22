package com.interview.model.projection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemplateLine {

    private String id;

    private String name;

    private String direction;

    private boolean favourite;
}
