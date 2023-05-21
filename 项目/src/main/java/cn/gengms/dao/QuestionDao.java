package cn.gengms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.Question;
import cn.gengms.util.C3p0Util;

public class QuestionDao {

	private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveQuestion(Question question) {
		String sqlString = "insert into question(title, content, img_url) values(?,?,?)";
		try {
			return queryRunner.execute(sqlString, question.getTitle(), question.getContent(), question.getImgUrl());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public Integer removeQuestion(Integer id) {
		String sqlString = "delete from question where id = ?";
		try {
			return queryRunner.execute(sqlString, id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<Question> listQuestions() {
		String sqlString = "select id,title,content,img_url imgUrl from question";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<Question>(Question.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
