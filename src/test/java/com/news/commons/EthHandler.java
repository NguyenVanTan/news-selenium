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

import com.news.commons.beans.Eth;

public class EthHandler extends BeanListHandler<Eth> {

	private Connection connection;

	public EthHandler(Connection connection) {
		super(Eth.class,new BasicRowProcessor(new BeanProcessor(getColumnsToFieldsMap())));
		this.connection = connection;

	}

	@Override
	public List<Eth> handle(ResultSet rs) throws SQLException {

		List<Eth> articles = super.handle(rs);
		return articles;

	}
	
	
	   public static Map<String, String> getColumnsToFieldsMap() {
	        Map<String, String> columnsToFieldsMap = new HashMap<>();
	        columnsToFieldsMap.put("id", "id");
	        columnsToFieldsMap.put("ask", "ask");
	        columnsToFieldsMap.put("bid", "bid");
	        columnsToFieldsMap.put("insertDate", "insert_date");
	        
	        return columnsToFieldsMap;
	    }
	   
}
