package oil.detection.controller.bis;

import com.base.common.DictionaryUtil;
import com.base.entity.BaseEntity;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.*;
import oil.detection.page.bis.OrderPage;
import oil.detection.service.bis.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能：</b>OrderController<br>
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseAction {

    private final static Logger log = Logger.getLogger(OrderController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private OrderService<Order> orderService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private UserService<User> userService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private SupplierService<Supplier> supplierService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private ProductService<Product> productService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private PurchaseService<Purchase> purchaseService;


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(OrderPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/order", context);
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
    public void datalist(OrderPage page, HttpServletResponse response) throws Exception {
        List<Order> dataList = orderService.queryByList(page);
        for (Order order : dataList) {
            order.setPay_type_desc(DictionaryUtil.dictionaryMap.get(order.getPay_type()));
            order.setDelivery_type_desc(DictionaryUtil.dictionaryMap.get(order.getDelivery_type()));
            order.setUser_name(userService.queryById(order.getUser_id()).getReal_name());
            order.setSupplier_name(supplierService.queryById(order.getSupplier_id()).getCompany_name());
            order.setProduct_name(productService.queryById(order.getProduct_id()).getName());
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
//    @RequestMapping("/save")
//    public void save(Order entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
//        Map<String, Object> context = new HashMap<String, Object>();
//        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
//            orderService.add(entity);
//        } else {
//            orderService.updateBySelective(entity);
//        }
//        sendSuccessMessage(response, "保存成功~");
//    }
    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Order entity = orderService.queryById(id);
        if (entity == null) {
            sendFailureMessage(response, "没有找到对应的记录!");
            return;
        }
        context.put(SUCCESS, true);
        context.put("data", entity);
        HtmlUtil.writerJson(response, context);
    }

    /**
     * 生成订单
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public void save(int purchaseId, int supplierId, HttpServletResponse response) throws Exception {
        Purchase purchaseUpdate = new Purchase();
        purchaseUpdate.setId(purchaseId);
        purchaseUpdate.setSupplier_id(supplierId);
        purchaseService.updateBySelective(purchaseUpdate);

        Purchase purchase = purchaseService.queryById(purchaseId);
        purchase.setSupplier_id(supplierId);

        Order order = new Order();
        BeanUtils.copyProperties(purchase, order);
        order.setOrder_type(purchase.getPurchase_type());
        order.setReceiver_addr(purchase.getDelivery_addr());
        order.setPurchase_id(purchaseId);

        Product product = productService.queryById(purchase.getProduct_id());
        order.setPrice(product.getPrice());
        order.setTotal_price(order.getNumber().multiply(order.getPrice()));
        User user = userService.queryById(purchase.getUser_id());
        order.setReceiver_name(user.getReal_name());
        order.setReceiver_phone(user.getUser_id());

        OrderPage orderPage = new OrderPage();
        orderPage.setPurchase_id(purchaseId);
        List<Product> products = productService.queryByList(orderPage);
        for (Product product1 : products) {
            productService.delete(product1.getId());
        }
        orderService.add(order);

        sendSuccessMessage(response, "保存成功~");
    }

}
