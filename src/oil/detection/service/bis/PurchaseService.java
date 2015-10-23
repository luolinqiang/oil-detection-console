package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.PurchaseDao;

/**
 * <b>功能：</b>PurchaseService<br>
 */
@Service("purchaseService")
public class PurchaseService<T> extends BaseService<T> {
    private final static Logger log = Logger.getLogger(PurchaseService.class);


    @Autowired
    private PurchaseDao<T> dao;


    public PurchaseDao<T> getDao() {
        return dao;
    }

}
