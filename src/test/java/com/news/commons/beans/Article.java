package com.news.commons.beans;

public class Article {
	
	private Integer id;
	private String title;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String desc;
	private  String content;
	public Article(Integer id, String title, String desc, String content) {
		this.setId(id);
		this.setTitle(title);
		this.desc=desc;
		this.content=content;
	}
	public Article() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
