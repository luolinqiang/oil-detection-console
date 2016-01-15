package oil.detection.service.bis;

import com.base.service.BaseService;
import oil.detection.dao.bis.OrderDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>功能：</b>OrderService<br>
 */
@Service("orderService")
public class OrderService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(OrderService.class);
	

	

	@Autowired
    private OrderDao<T> dao;

		
	public OrderDao<T> getDao() {
		return dao;
	}

}
