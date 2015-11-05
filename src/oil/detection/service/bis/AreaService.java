package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.AreaDao;

/**
 * <b>功能：</b>AreaService<br>
 */
@Service("areaService")
public class AreaService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(AreaService.class);
	

	

	@Autowired
    private AreaDao<T> dao;

		
	public AreaDao<T> getDao() {
		return dao;
	}

}
