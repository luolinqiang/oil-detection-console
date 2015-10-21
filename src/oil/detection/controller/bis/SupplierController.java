package oil.detection.controller.bis;

import com.base.common.DictionaryUtil;
import com.base.entity.BaseEntity;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.Dictionary;
import oil.detection.entity.bis.Supplier;
import oil.detection.page.bis.DictionaryPage;
import oil.detection.page.bis.SupplierPage;
import oil.detection.service.bis.SupplierService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能：</b>SupplierController<br>
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseAction {

    private final static Logger log = Logger.getLogger(SupplierController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private SupplierService<Supplier> supplierService;


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/supplier", context);
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
    public void datalist(SupplierPage page, HttpServletResponse response) throws Exception {
        List<Supplier> dataList = supplierService.queryByList(page);
        for (Supplier supplier : dataList) {
            supplier.setCompany_type_desc(DictionaryUtil.dictionaryMap.get(supplier.getCompany_type()));
        }
        //设置页面数据
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", page.getPager().getRowCount());
        jsonMap.put("rows", dataList);
        HtmlUtil.writerJson(response, jsonMap);
    }

    @RequestMapping("/dataJson")
    public void dataJson(SupplierPage page, HttpServletResponse response) throws Exception {
        List<Supplier> dataList = supplierService.queryByList(page);
        HtmlUtil.writerJson(response, dataList);
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
    public void save(Supplier entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();
        entity.setType(BaseEntity.TYPE_COMMON.TWO.key);
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            entity.setCreate_time(new Date());
            entity.setState(BaseEntity.STATE_COMMON.PUBLICATION.key);
            supplierService.add(entity);
        } else {
            supplierService.update(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Supplier entity = supplierService.queryById(id);
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
        supplierService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

}
