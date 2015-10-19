package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.PicDao;

/**
 * <b>功能：</b>PicService<br>
 */
@Service("picService")
public class PicService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(PicService.class);
	

	

	@Autowired
    private PicDao<T> dao;

		
	public PicDao<T> getDao() {
		return dao;
	}

}
