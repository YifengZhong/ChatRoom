package com.Ilvcode.controller;

public class MessageInfo {
	private String name;
	private String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageInfo() {
    }

    public MessageInfo(String name,String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
