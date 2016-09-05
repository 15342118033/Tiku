package com.yu.test.tiku.pojo;

/**
 * 所有知识点分类用的实体类，
 * 响应JSON字符串需要id，icon，name
 */

public class Types {
    private String id;
    private String icon;
    private String name;

    public Types() {
    }

    public Types(String id, String icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
