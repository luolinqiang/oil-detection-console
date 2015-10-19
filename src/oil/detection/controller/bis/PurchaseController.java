package oil.detection.controller.bis;

import com.base.common.DictionaryUtil;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.Purchase;
import oil.detection.page.bis.PurchasePage;
import oil.detection.service.bis.PurchaseService;
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
 * <b>功能：</b>PurchaseController<br>
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController extends BaseAction {

    private final static Logger log = Logger.getLogger(PurchaseController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private PurchaseService<Purchase> purchaseService;


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(PurchasePage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/purchase", context);
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
    public void datalist(PurchasePage page, HttpServletResponse response) throws Exception {
        List<Purchase> dataList = purchaseService.queryByList(page);
        for (Purchase purchase : dataList) {
            purchase.setQuality_standard_desc(DictionaryUtil.dictionaryMap.get(purchase.getQuality_standard()));
            purchase.setProduct_id_desc(DictionaryUtil.dictionaryMap.get(purchase.getProduct_id()));
            purchase.setPay_type_desc(DictionaryUtil.dictionaryMap.get(purchase.getPay_type()));
            purchase.setDelivery_type_desc(DictionaryUtil.dictionaryMap.get(purchase.getDelivery_type()));
        }
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
    public void save(Purchase entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            purchaseService.add(entity);
        } else {
            purchaseService.update(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Purchase entity = purchaseService.queryById(id);
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
        purchaseService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

}
