package cn.gengms.entity;

public class ForeignCovidData {
	private String date;
	private String nowSure;
	private String newAdd;
	private String newDied;
	private String newSave;

	public ForeignCovidData() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ForeignCovidData(String date, String nowSure, String newAdd, String newDied, String newSave) {
		super();
		this.date = date;
		this.nowSure = nowSure;
		this.newAdd = newAdd;
		this.newDied = newDied;
		this.newSave = newSave;
	}

	@Override
	public String toString() {
		return "ForeignCovidData [date=" + date + ", nowSure=" + nowSure + ", newAdd=" + newAdd + ", newDied=" + newDied
				+ ", newSave=" + newSave + "]";
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

	public String getNewAdd() {
		return newAdd;
	}

	public void setNewAdd(String newAdd) {
		this.newAdd = newAdd;
	}

	public String getNewDied() {
		return newDied;
	}

	public void setNewDied(String newDied) {
		this.newDied = newDied;
	}

	public String getNewSave() {
		return newSave;
	}

	public void setNewSave(String newSave) {
		this.newSave = newSave;
	}

}
