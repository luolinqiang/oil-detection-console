package oil.detection.controller.bis;

import com.base.common.DictionaryUtil;
import com.base.entity.BaseEntity;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.jeecg.exception.ServiceException;
import oil.detection.entity.bis.Pic;
import oil.detection.entity.bis.Supplier;
import oil.detection.page.bis.SupplierPage;
import oil.detection.service.bis.PicService;
import oil.detection.service.bis.SupplierService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private PicService<Pic> picService;


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
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listSelect")
    public ModelAndView listSelect(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/supplier-select", context);
    }

    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listAreaSelect")
    public ModelAndView listAreaSelect(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/area-select", context);
    }

    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listDirect")
    public ModelAndView listDirect(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/supplierDirect", context);
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
    public void save(Supplier entity, Integer[] typeIds, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            // 获得文件：
            MultipartFile file = multipartRequest.getFile("file");
            if (file != null && !file.isEmpty()) {
                String picUrl = UUID.randomUUID().toString();
                byte[] bytes = file.getBytes();
                Pic pic = new Pic();
                pic.setType(BaseEntity.PIC_TYPE.SUPPLIER.key);
                pic.setContent(bytes);
                pic.setPic_url(picUrl);
                pic.setCreate_time(new Date());
                picService.add(pic);
                entity.setCompany_logo(pic.getId() + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity.setCompany_logo(null);
        }

        entity.setType(BaseEntity.TYPE_COMMON.TWO.key);
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            entity.setCreate_time(new Date());
            entity.setState(BaseEntity.STATE_COMMON.PUBLICATION.key);
            supplierService.add(entity);
        } else {
            supplierService.updateBySelective(entity);
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
