package net.amal.framework.xml;

import jakarta.xml.bind.annotation.XmlAttribute;

public class BeanConfig {

    private String id;
    private String className;

    public BeanConfig() {
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "class")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}