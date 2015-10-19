package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.FeedbackDao;

/**
 * <b>功能：</b>FeedbackService<br>
 */
@Service("feedbackService")
public class FeedbackService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(FeedbackService.class);
	

	

	@Autowired
    private FeedbackDao<T> dao;

		
	public FeedbackDao<T> getDao() {
		return dao;
	}

}
