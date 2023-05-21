package cn.gengms.service.impl;

import java.util.List;

import cn.gengms.dao.QuestionDao;
import cn.gengms.entity.Question;
import cn.gengms.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao = new QuestionDao();

	@Override
	public Boolean saveQuestion(Question question) {
		// TODO 自动生成的方法存根
		Integer counInteger = questionDao.saveQuestion(question);
		if (counInteger != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean removeQuestion(Integer id) {
		// TODO 自动生成的方法存根
		Integer countInteger = questionDao.removeQuestion(id);
		if (countInteger != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Question> listQuestion() {
		// TODO 自动生成的方法存根
		return questionDao.listQuestions();
	}

}
