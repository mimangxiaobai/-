package cn.gengms.entity;

import com.alibaba.excel.annotation.ExcelProperty;

public class ChinaData {
	@ExcelProperty("地名")
	private String name;

	@ExcelProperty("现存确诊")
	private String now_have;

	@ExcelProperty("累计确诊")
	private String total_have;

	public ChinaData() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ChinaData(String name, String now_have, String total_have) {
		super();
		this.name = name;
		this.now_have = now_have;
		this.total_have = total_have;
	}

	@Override
	public String toString() {
		return "ChinaData [name=" + name + ", now_have=" + now_have + ", total_have=" + total_have + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNow_have() {
		return now_have;
	}

	public void setNow_have(String now_have) {
		this.now_have = now_have;
	}

	public String getTotal_have() {
		return total_have;
	}

	public void setTotal_have(String total_have) {
		this.total_have = total_have;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		try {
			ChinaData chinaData = (ChinaData) obj;
			if (!this.name.equals(chinaData.getName())) {
				return false;
			} else if (!this.now_have.equals(chinaData.getNow_have())) {
				return false;
			} else if (!this.total_have.equals(chinaData.getTotal_have())) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
