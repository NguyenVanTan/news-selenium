package com.news.selenium;

import static org.testng.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.news.commons.DefaultTestDatabase;
import com.news.commons.ArticleHandler;
import com.news.commons.beans.Article;

public class OracleArticleDatabaseTest extends DefaultTestDatabase {
	PreparedStatement preparedStatement;
	private static Logger logger = LoggerFactory.getLogger(OracleArticleDatabaseTest.class);

	// @Test
	// public void pushDataToArticalTable() {
	// driver.get(DEFAULT_HOME_BASCIC_AUTHENT);
	//
	// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//
	// List<WebElement> elements = new JavaArticlePage(driver).getListArtical();
	//
	// elements.forEach(element -> {
	// Article article =new
	// Article(null,element.getText(),element.getText(),element.getText());
	// insertArtical(article);
	// logger.info(element.getText());
	//
	// });
	//
	// }
	//

	@Test
	public void getListArticleByMapListHandler() throws SQLException {
		MapListHandler beanListHandler = new MapListHandler();

		List<Map<String, Object>> list = queryRunner.query(connection, "SELECT * FROM article", beanListHandler);
		assertEquals(list.size(), 6);
	}

	@Test
	public void givenResultHandler_whenExecutingQuery_thenEmailsSetted() throws SQLException {
		ArticleHandler employeeHandler = new ArticleHandler(connection);
		List<Article> articles = queryRunner.query(connection, "SELECT * FROM article", employeeHandler);
		assertEquals(articles.get(0).getContent(), "spaces you follow");

	}

	@Test
	public void getListArticleByBeanListHandler() {
		try {
			BeanListHandler<Article> listArticle = new BeanListHandler<>(Article.class);
			List<Article> list = queryRunner.query(connection, "select * from article", listArticle);
			logger.info((list.get(0).toString()));
			assertEquals(list.size(), 6);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void givenResultHandler_whenExecutingQuery_thenExpectedScalar() throws SQLException {
		ScalarHandler<Long> scalarHandler = new ScalarHandler<>();

		String query = "SELECT COUNT(*) FROM article";
		long count = queryRunner.query(connection, query, scalarHandler);

		assertEquals(count, 6);
	}

	@Test
	public void givenResultHandlerByBeanProcesser() throws SQLException {
		ArticleHandler articleHandler = new ArticleHandler(connection);

		String query = "SELECT * FROM article";
		List<Article> articles = queryRunner.query(connection, query, articleHandler);

		assertEquals((int) articles.get(0).getId(), 1);
		assertEquals(articles.get(0).getTitle(), "spaces you follow");
	}

	@Test
	public void insertArticle() throws SQLException {
		String query = " INSERT INTO article(`title`,`desc`,`content`) " + " values(?, ?, ?)";
		int numberRowInserted = queryRunner.update(connection, query, "title1", "desc1", "contents1 ");
		assertEquals(numberRowInserted, 1);
	}

	@Test
	public void insertArticle2() throws SQLException {
		ScalarHandler<Long> scalarHandler = new ScalarHandler<>();

		String query = " INSERT INTO article(`title`,`desc`,`content`) " + " values(?, ?, ?)";

		Long newId = queryRunner.insert(connection, query, scalarHandler, "Article1", "desc 2", "contents 2");

		assertEquals(newId, Long.valueOf(8));
	}

	@Test
	public void updateArticle() throws SQLException {
		String updateSQL = "UPDATE article SET title ='test title 1'  WHERE title='Java'";
		int numRowsUpdated = queryRunner.update(connection, updateSQL);

		assertEquals(numRowsUpdated, 3);
	}

	@Test
	public void deleteArticleWhenIdGtThan5() throws SQLException {
		String deleteSQL = "DELETE FROM article WHERE id > ?";
		int numRowsDeleted = queryRunner.update(connection, deleteSQL, 5);

		assertEquals(numRowsDeleted, 1);
	}

	@Test
	public void givenAsyncRunner() throws Exception {
		AsyncQueryRunner runner = new AsyncQueryRunner(Executors.newCachedThreadPool());

		ArticleHandler employeeHandler = new ArticleHandler(connection);
		String query = "SELECT * FROM article";
		Future<List<Article>> future = runner.query(connection, query, employeeHandler);
		List<Article> articleList = future.get(10, TimeUnit.SECONDS);

		assertEquals(articleList.size(), 8);
	}

	//
	// public void insertArtical(Article article) {
	// try {
	// String query = " INSERT INTO article(`title`,`desc`,`content`) " + "
	// values(?, ?, ?)";
	//
	// preparedStatement = connection.prepareStatement(query);
	// preparedStatement.setString(1, article.getTitle());
	// preparedStatement.setString(2, article.getDesc());
	// preparedStatement.setString(3, article.getContent());
	// preparedStatement.execute();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
