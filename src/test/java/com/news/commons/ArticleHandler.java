package com.news.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.news.commons.beans.Article;

public class ArticleHandler extends BeanListHandler<Article> {

	private Connection connection;

	public ArticleHandler(Connection connection) {
		super(Article.class,new BasicRowProcessor(new BeanProcessor(getColumnsToFieldsMap())));
		this.connection = connection;

	}

	@Override
	public List<Article> handle(ResultSet rs) throws SQLException {

		List<Article> articles = super.handle(rs);
		return articles;

	}
	
	
	   public static Map<String, String> getColumnsToFieldsMap() {
	        Map<String, String> columnsToFieldsMap = new HashMap<>();
	        columnsToFieldsMap.put("id", "id");
	        columnsToFieldsMap.put("title", "title");
	        columnsToFieldsMap.put("desc", "desc");
	        columnsToFieldsMap.put("content", "content");
	        
	        return columnsToFieldsMap;
	    }
	   
}
