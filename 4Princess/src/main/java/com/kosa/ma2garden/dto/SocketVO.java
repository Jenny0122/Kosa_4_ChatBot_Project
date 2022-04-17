package com.kosa.ma2garden.dto;

public class SocketVO {

	private String userName; // 유저의 이름을 저장하기 위한 변수
	private String content; // 메시지의 내용을 저장하기 위한 변수

	public SocketVO() {
		super();
	}

	public SocketVO(String userName, String content) {
		super();
		this.userName = userName;
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SocketVO [userName=" + userName + ", content=" + content + "]";
	}

}
