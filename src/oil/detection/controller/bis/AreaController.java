package oil.detection.controller.bis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.base.web.BaseAction;
import com.base.util.HtmlUtil;
import com.base.entity.BaseEntity.DELETED;
import oil.detection.entity.bis.Area;
import oil.detection.page.bis.AreaPage;
import oil.detection.service.bis.AreaService;

/**
 * <b>功能：</b>AreaController<br>
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseAction {

    private final static Logger log = Logger.getLogger(AreaController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private AreaService<Area> areaService;


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(AreaPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/area", context);
    }


    /**
     * ilook 首页
     *
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/dataList")
    public void datalist(AreaPage page, HttpServletResponse response) throws Exception {
        List<Area> dataList = areaService.queryByList(page);
        //设置页面数据
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", page.getPager().getRowCount());
        jsonMap.put("rows", dataList);
        HtmlUtil.writerJson(response, jsonMap);
    }

    /**
     * 添加或修改数据
     *
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public void save(Area entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            areaService.add(entity);
        } else {
            areaService.updateBySelective(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Area entity = areaService.queryById(id);
        if (entity == null) {
            sendFailureMessage(response, "没有找到对应的记录!");
            return;
        }
        context.put(SUCCESS, true);
        context.put("data", entity);
        HtmlUtil.writerJson(response, context);
    }


    @RequestMapping("/delete")
    public void delete(String[] id, HttpServletResponse response) throws Exception {
        areaService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

}