package oil.detection.controller.bis;

import com.base.common.DictionaryUtil;
import com.base.page.BasePage;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import oil.detection.entity.bis.Dictionary;
import oil.detection.page.bis.DictionaryPage;
import oil.detection.service.bis.DictionaryService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能：</b>DictionaryController<br>
 */
@Controller
@RequestMapping("/dic")
public class DictionaryController extends BaseAction {

    private final static Logger log = Logger.getLogger(DictionaryController.class);

    // Servrice start
    @Autowired(required = false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
    private DictionaryService<Dictionary> dictionaryService;

    @PostConstruct
    public void initDictionary() throws Exception {
        DictionaryPage page = new DictionaryPage();
        page.setRows(100000);
        List<Dictionary> dictionaries = dictionaryService.queryByList(page);
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Dictionary dictionary : dictionaries) {
            if (dictionary != null) {
                map.put(dictionary.getId(), dictionary.getName());
            }
        }
        DictionaryUtil.dictionaryMap = map;
    }


    /**
     * @param url
     * @param classifyId
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list(DictionaryPage page, HttpServletRequest request) throws Exception {
        Map<String, Object> context = getRootMap();
        return forword("oil/detection/bis/dictionary", context);
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
    public void datalist(DictionaryPage page, HttpServletResponse response) throws Exception {
        List<Dictionary> dataList = dictionaryService.queryByList(page);
        //设置页面数据
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", page.getPager().getRowCount());
        jsonMap.put("rows", dataList);
        HtmlUtil.writerJson(response, jsonMap);
    }

    @RequestMapping("/dataJson")
    public void dataJson(DictionaryPage page, HttpServletResponse response) throws Exception {
        List<Dictionary> dataList = dictionaryService.queryByList(page);
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
    public void save(Dictionary entity, Integer[] typeIds, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap<String, Object>();
        if (entity.getId() == null || StringUtils.isBlank(entity.getId().toString())) {
            dictionaryService.add(entity);
        } else {
            dictionaryService.update(entity);
        }
        sendSuccessMessage(response, "保存成功~");
    }


    @RequestMapping("/getId")
    public void getId(String id, HttpServletResponse response) throws Exception {
        Map<String, Object> context = new HashMap();
        Dictionary entity = dictionaryService.queryById(id);
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
        dictionaryService.delete(id);
        sendSuccessMessage(response, "删除成功");
    }

}
