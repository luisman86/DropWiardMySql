package com.itexico.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Part {

    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String code;

    public Part(int id, String name, String code) {
        super();
        this.setId(id);
        this.setName(name);
        this.setCode(code);
    }

    public Part() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
