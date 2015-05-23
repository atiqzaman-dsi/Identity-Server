package org.freeshr.identity.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class Resource {


    private String value;

    public Resource(String value) {
        this.value = value;
    }

    @JsonValue
    @JsonRawValue
    public String getValue() {
        return value;
    }

    public void replace(String content, String with) {
        if (value.indexOf(content) > -1) {
            value = value.replace(content, with);
        }

    }
}
