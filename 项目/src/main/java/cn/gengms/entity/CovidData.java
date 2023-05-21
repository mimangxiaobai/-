package cn.gengms.entity;

public class CovidData {

	private String date;
	private String nowSure;
	private String nowAdd;
	private String nowIcu;
	private String addSure;
	private String addDied;
	private String addSave;

	public CovidData() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public CovidData(String date, String nowSure, String nowAdd, String nowIcu, String addSure, String addDied,
			String addSave) {
		super();
		this.date = date;
		this.nowSure = nowSure;
		this.nowAdd = nowAdd;
		this.nowIcu = nowIcu;
		this.addSure = addSure;
		this.addDied = addDied;
		this.addSave = addSave;
	}

	@Override
	public String toString() {
		return "CovidData [date=" + date + ", nowSure=" + nowSure + ", nowAdd=" + nowAdd + ", nowIcu=" + nowIcu
				+ ", addSure=" + addSure + ", addDied=" + addDied + ", addSave=" + addSave + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNowSure() {
		return nowSure;
	}

	public void setNowSure(String nowSure) {
		this.nowSure = nowSure;
	}

	public String getNowAdd() {
		return nowAdd;
	}

	public void setNowAdd(String nowAdd) {
		this.nowAdd = nowAdd;
	}

	public String getNowIcu() {
		return nowIcu;
	}

	public void setNowIcu(String nowIcu) {
		this.nowIcu = nowIcu;
	}

	public String getAddSure() {
		return addSure;
	}

	public void setAddSure(String addSure) {
		this.addSure = addSure;
	}

	public String getAddDied() {
		return addDied;
	}

	public void setAddDied(String addDied) {
		this.addDied = addDied;
	}

	public String getAddSave() {
		return addSave;
	}

	public void setAddSave(String addSave) {
		this.addSave = addSave;
	}

}
