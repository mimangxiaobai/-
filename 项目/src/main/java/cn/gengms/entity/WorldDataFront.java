package cn.gengms.entity;

public class WorldDataFront {
	private Double nowSureMore;
	private Double nowSure;
	private Double addSureMore;
	private Double addSure;
	private Double addDiedMore;
	private Double addDied;
	private Double addSaveMore;
	private Double addSave;

	public WorldDataFront() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public WorldDataFront(Double nowSureMore, Double nowSure, Double addSureMore, Double addSure, Double addDiedMore,
			Double addDied, Double addSaveMore, Double addSave) {
		super();
		this.nowSureMore = nowSureMore;
		this.nowSure = nowSure;
		this.addSureMore = addSureMore;
		this.addSure = addSure;
		this.addDiedMore = addDiedMore;
		this.addDied = addDied;
		this.addSaveMore = addSaveMore;
		this.addSave = addSave;
	}

	@Override
	public String toString() {
		return "WorldDataFront [nowSureMore=" + nowSureMore + ", nowSure=" + nowSure + ", addSureMore=" + addSureMore
				+ ", addSure=" + addSure + ", addDiedMore=" + addDiedMore + ", addDied=" + addDied + ", addSaveMore="
				+ addSaveMore + ", addSave=" + addSave + "]";
	}

	public Double getNowSureMore() {
		return nowSureMore;
	}

	public void setNowSureMore(Double nowSureMore) {
		this.nowSureMore = nowSureMore;
	}

	public Double getNowSure() {
		return nowSure;
	}

	public void setNowSure(Double nowSure) {
		this.nowSure = nowSure;
	}

	public Double getAddSureMore() {
		return addSureMore;
	}

	public void setAddSureMore(Double addSureMore) {
		this.addSureMore = addSureMore;
	}

	public Double getAddSure() {
		return addSure;
	}

	public void setAddSure(Double addSure) {
		this.addSure = addSure;
	}

	public Double getAddDiedMore() {
		return addDiedMore;
	}

	public void setAddDiedMore(Double addDiedMore) {
		this.addDiedMore = addDiedMore;
	}

	public Double getAddDied() {
		return addDied;
	}

	public void setAddDied(Double addDied) {
		this.addDied = addDied;
	}

	public Double getAddSaveMore() {
		return addSaveMore;
	}

	public void setAddSaveMore(Double addSaveMore) {
		this.addSaveMore = addSaveMore;
	}

	public Double getAddSave() {
		return addSave;
	}

	public void setAddSave(Double addSave) {
		this.addSave = addSave;
	}

}
