package cn.gengms.service;

import java.util.List;

import cn.gengms.entity.Question;

public interface QuestionService {
	Boolean saveQuestion(Question question);

	Boolean removeQuestion(Integer id);

	List<Question> listQuestion();
}
