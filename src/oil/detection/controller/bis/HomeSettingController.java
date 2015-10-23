package oil.detection.controller.bis;

import com.base.entity.BaseEntity;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.jeecg.exception.ServiceException;
import oil.detection.entity.bis.HomeSetting;
import oil.detection.entity.bis.Pic;
import oil.detection.entity.bis.Supplier;
import oil.detection.page.bis.HomeSettingPage;
import oil.detection.page.bis.SupplierPage;
import oil.detection.service.bis.HomeSettingService;
import oil.detection.service.bis.PicService;
import oil.detection.service.bis.SupplierService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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
 * <b>功能：</b>HomeSettingController<br>
 */
@Controller
@RequestMapping("/homeSetting")
public class HomeSettingController extends BaseAction {

    private final static Logger log = Logger.getLogger(HomeSettingController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private HomeSettingService<HomeSetting> homeSettingService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private PicService<Pic> picService;
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private SupplierService<Supplier> supplierService;


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(HomeSettingPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/homeSetting", context);
    }

    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listSupplier")
    public ModelAndView listSupplier(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/homeSupplier", context);
    }

    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listCustom")
    public ModelAndView listCustom(SupplierPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/homeCustom", context);
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
    public void datalist(HomeSettingPage page, HttpServletResponse response) throws Exception {
        List<HomeSetting> dataList = homeSettingService.queryByList(page);
        for (HomeSetting homeSetting : dataList) {
            if (homeSetting.getType() == BaseEntity.TYPE_COMMON.TWO.key) {
                Supplier supplier = supplierService.queryById(homeSetting.getTarget_id());
                if (supplier != null) {
                    homeSetting.setSupplier_name(supplier.getCompany_name());
                }
            }
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
    @RequestMapping("/bannerSave")
    public void bannerSave(HttpServletRequest request, HomeSetting entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        if (checkNum(response, 1, 6)) return;
        if (checkRepeat(response, 1, entity)) return;

        Map<String, Object> context = new HashMap<String, Object>();

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            // 获得文件：
            MultipartFile file = multipartRequest.getFile("file");
            if (file != null && !file.isEmpty()) {
                String picUrl = UUID.randomUUID().toString();
                byte[] bytes = file.getBytes();
                Pic pic = new Pic();
                pic.setType(BaseEntity.PIC_TYPE.BANNER.key);
                pic.setContent(bytes);
                pic.setPic_url(picUrl);
                pic.setCreate_time(new Date());
                picService.add(pic);
                entity.setTarget_id(pic.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("请选择待上传文件");
        }
        entity.setType(BaseEntity.HOME_TYPE.BANNER.key);
        entity.setCreate_time(new Date());
        entity.setState(BaseEntity.STATE_COMMON.SAVE.key);
        entity.setState(BaseEntity.STATE_COMMON.SAVE.key);
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            homeSettingService.add(entity);
        } else {
            homeSettingService.updateBySelective(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }

    /**
     * 添加或修改数据
     *
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/supplierSave")
    public void supplierSave(HttpServletRequest request, HomeSetting entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        if (checkNum(response, 2, 4)) return;
        if (checkRepeat(response, 2, entity)) return;

        entity.setType(BaseEntity.HOME_TYPE.DIRECTSALE.key);
        entity.setCreate_time(new Date());
        entity.setState(BaseEntity.STATE_COMMON.SAVE.key);
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            homeSettingService.add(entity);
        } else {
            homeSettingService.updateBySelective(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }

    /**
     * 添加或修改数据
     *
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/customSave")
    public void customSave(HttpServletRequest request, HomeSetting entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        if (checkNum(response, 4, 2)) return;
        if (checkRepeat(response, 4, entity)) return;

        entity.setType(BaseEntity.HOME_TYPE.LINK.key);
        entity.setCreate_time(new Date());
        entity.setState(BaseEntity.STATE_COMMON.SAVE.key);
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            homeSettingService.add(entity);
        } else {
            homeSettingService.updateBySelective(entity);
        }
        sendSuccessMessage(response, "保存成功~");
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
    public void save(HttpServletRequest request, HomeSetting entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            homeSettingService.add(entity);
        } else {
            homeSettingService.updateBySelective(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }

    private boolean checkNum(HttpServletResponse response, int type, int max) throws Exception {
        HomeSettingPage page = new HomeSettingPage();
        page.setType(type);
        int count = homeSettingService.queryByCount(page);
        if (count >= max) {
            throw new ServiceException("最多只能上传" + max + "条记录.");
        }
        return false;
    }

    private boolean checkRepeat(HttpServletResponse response, int type, HomeSetting homeSetting) throws Exception {
        HomeSettingPage page = new HomeSettingPage();
        BeanUtils.copyProperties(homeSetting, page);
        page.setType(type);
        int count = homeSettingService.queryByCount(page);
        if (count > 0) {
            throw new ServiceException("排序号已经存在");
        }
        return false;
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        HomeSetting entity = homeSettingService.queryById(id);
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
        homeSettingService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

}
