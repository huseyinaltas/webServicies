package com.chapter2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "testdata")
public class TestData {
    private String name;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}