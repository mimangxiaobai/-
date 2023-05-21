package cn.gengms.entity;

public class HomeArticle {
	private Integer id;
	private String title;
	private String articleUrl;
	private String imgUrl;

	public HomeArticle() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public HomeArticle(Integer id, String title, String articleUrl, String imgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.articleUrl = articleUrl;
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "HomeArticle [id=" + id + ", title=" + title + ", articleUrl=" + articleUrl + ", imgUrl=" + imgUrl + "]";
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

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
