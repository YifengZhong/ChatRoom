package com.Ilvcode.domain;

public class MessageInfo {
	//sender
	private String name;
	//message content
	private String content;
	//receiver
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
