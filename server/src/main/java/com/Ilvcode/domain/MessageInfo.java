package com.Ilvcode.domain;

public class MessageInfo {
	private String name;
	private String content;
	private String toUser;

	public MessageInfo(){}
	public MessageInfo(String name, String content, String toUser) {
		this.name = name;
		this.content = content;
		this.toUser = toUser;
	}
	public String getToUser() {
		return toUser;
	}
	public String getContent() {
		return content;
	}
    public String getName() {
        return name;
    }
}
