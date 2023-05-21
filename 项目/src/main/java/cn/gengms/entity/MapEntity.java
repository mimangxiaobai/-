package cn.gengms.entity;

public class MapEntity {
	private String name;
	private String value;

	public MapEntity() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public MapEntity(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "MapEntity [name=" + name + ", value=" + value + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
