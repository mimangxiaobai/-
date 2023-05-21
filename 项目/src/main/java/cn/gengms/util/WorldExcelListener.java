package cn.gengms.util;

import java.sql.SQLException;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import cn.gengms.dao.WorldDataDao;
import cn.gengms.entity.ChinaData;

public class WorldExcelListener extends AnalysisEventListener<ChinaData> {

	private WorldDataDao worldDataDao = new WorldDataDao();

	@Override
	public void doAfterAllAnalysed(AnalysisContext arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void invoke(ChinaData arg0, AnalysisContext arg1) {
		try {
			worldDataDao.updateWorldData(arg0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
