package oil.detection.controller.bis;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.DiscoveryCar;
import oil.detection.page.bis.DiscoveryCarPage;
import oil.detection.service.bis.DiscoveryCarService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
/**
 * <b>功能：</b>DiscoveryCarController<br>
 */
@Controller
@RequestMapping("/discoveryCar") 
public class DiscoveryCarController extends BaseAction{
	
	private final static Logger log= Logger.getLogger(DiscoveryCarController.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private DiscoveryCarService<DiscoveryCar> discoveryCarService; 
	
	
	
	
	
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(DiscoveryCarPage page,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("oil/detection/bis/discoveryCar",context);
	}
	
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(DiscoveryCarPage page,HttpServletResponse response) throws Exception{
		List<DiscoveryCar> dataList = discoveryCarService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(DiscoveryCar entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			discoveryCarService.add(entity);
		}else{
			discoveryCarService.updateBySelective(entity);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	
	@RequestMapping("/getId")
	public void getId(String id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap();
		DiscoveryCar entity  = discoveryCarService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		HtmlUtil.writerJson(response, context);
	}
	
	
	
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletResponse response) throws Exception{
		discoveryCarService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

}
