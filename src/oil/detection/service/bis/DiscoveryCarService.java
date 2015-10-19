package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.DiscoveryCarDao;

/**
 * <b>功能：</b>DiscoveryCarService<br>
 */
@Service("discoveryCarService")
public class DiscoveryCarService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(DiscoveryCarService.class);
	

	

	@Autowired
    private DiscoveryCarDao<T> dao;

		
	public DiscoveryCarDao<T> getDao() {
		return dao;
	}

}
