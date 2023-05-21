package cn.gengms.entity;

public class Rumor {
	private Integer id;
	private String content;
	private Integer isRumor;

	public Rumor() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Rumor(Integer id, String content, Integer isRumor) {
		super();
		this.id = id;
		this.content = content;
		this.isRumor = isRumor;
	}

	@Override
	public String toString() {
		return "Rumor [id=" + id + ", content=" + content + ", isRumor=" + isRumor + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsRumor() {
		return isRumor;
	}

	public void setIsRumor(Integer isRumor) {
		this.isRumor = isRumor;
	}

}
