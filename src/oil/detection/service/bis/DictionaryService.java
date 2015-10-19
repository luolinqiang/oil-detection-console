package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.DictionaryDao;

/**
 * <b>功能：</b>DictionaryService<br>
 */
@Service("dictionaryService")
public class DictionaryService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(DictionaryService.class);
	

	

	@Autowired
    private DictionaryDao<T> dao;

		
	public DictionaryDao<T> getDao() {
		return dao;
	}

}
