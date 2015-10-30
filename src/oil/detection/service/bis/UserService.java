package oil.detection.service.bis;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import oil.detection.dao.bis.UserDao;

/**
 * <b>功能：</b>UserService<br>
 */
@Service("userService")
public class UserService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(UserService.class);
	

	

	@Autowired
    private UserDao<T> dao;

		
	public UserDao<T> getDao() {
		return dao;
	}

}
