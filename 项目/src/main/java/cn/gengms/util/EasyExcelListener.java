package cn.gengms.util;

import java.sql.SQLException;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import cn.gengms.dao.ChinaDataDao;
import cn.gengms.entity.ChinaData;

public class EasyExcelListener extends AnalysisEventListener<ChinaData> {

	private ChinaDataDao chinaDataDao = new ChinaDataDao();

	@Override
	public void doAfterAllAnalysed(AnalysisContext arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void invoke(ChinaData arg0, AnalysisContext arg1) {
		// TODO 自动生成的方法存根
		try {
			chinaDataDao.updateChinaData(arg0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
