package cn.gengms.entity;

public class Question {
	private Integer id;
	private String title;
	private String content;
	private String imgUrl;

	public Question() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Question(Integer id, String title, String content, String imgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", content=" + content + ", imgUrl=" + imgUrl + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
