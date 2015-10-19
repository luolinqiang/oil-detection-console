package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.HomeSettingDao;

/**
 * <b>功能：</b>HomeSettingService<br>
 */
@Service("homeSettingService")
public class HomeSettingService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(HomeSettingService.class);
	

	

	@Autowired
    private HomeSettingDao<T> dao;

		
	public HomeSettingDao<T> getDao() {
		return dao;
	}

}
