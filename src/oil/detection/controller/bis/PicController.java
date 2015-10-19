package oil.detection.controller.bis;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.Pic;
import oil.detection.service.bis.PicService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>功能：</b>PicController<br>
 */
@Controller
@RequestMapping("/pic")
public class PicController extends BaseAction {

    private final static Logger log = Logger.getLogger(PicController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private PicService<Pic> picService;


    /**
     * 添加或修改数据
     *
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public void save(Pic entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            picService.add(entity);
        } else {
            picService.update(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Pic entity = picService.queryById(id);
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
        picService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

    @RequestMapping(value = "/show/{id}")
    public void showId(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id)
            throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-Type", "image/png");
        Pic pic = new Pic();
        pic.setId(id);
        Pic picDb = picService.queryById(id);
        if (picDb != null && picDb.getContent() != null) {
            ServletOutputStream os = null;
            try {
                os = response.getOutputStream();
                os.write(picDb.getContent());
                os.flush();
            } finally {
                if (os != null) {
                    os.close();
                }
            }
        }
    }

}
