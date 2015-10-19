package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.SupplierDao;

/**
 * <b>功能：</b>SupplierService<br>
 */
@Service("supplierService")
public class SupplierService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(SupplierService.class);
	

	

	@Autowired
    private SupplierDao<T> dao;

		
	public SupplierDao<T> getDao() {
		return dao;
	}

}
