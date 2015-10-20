package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.ProductDao;

/**
 * <b>功能：</b>ProductService<br>
 */
@Service("productService")
public class ProductService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(ProductService.class);
	

	

	@Autowired
    private ProductDao<T> dao;

		
	public ProductDao<T> getDao() {
		return dao;
	}

}
