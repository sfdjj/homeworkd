package com.qunar.fresh2017.controller;

import com.google.common.base.Preconditions;
import com.qunar.fresh2017.model.ContentModel;
import com.qunar.fresh2017.model.ResultModel;
import com.qunar.fresh2017.service.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/counter")
public class CounterController {

    @Resource
    private CounterService counterService;


    @RequestMapping(value = "/getUrl",method = RequestMethod.GET)
    public String getUrl(@RequestParam("url") String url,
                         HttpServletRequest request) {
        counterService.save(url);
        int count = counterService.getCount();
        request.setAttribute("count",count);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel save(@RequestParam("title") String title
            , @RequestParam("number") Integer number
            , @RequestParam("chNumber") Integer chNumber
            , @RequestParam("enNumber") Integer enNumber
            , @RequestParam("puncNumber") Integer puncNumber) {
        Preconditions.checkNotNull(title,"title could not be null");
        Preconditions.checkNotNull(number,"number could not be null");
        Preconditions.checkNotNull(chNumber,"chNumber could not be null");
        Preconditions.checkNotNull(enNumber,"enNumber could not be null");
        Preconditions.checkNotNull(puncNumber,"puncNumber could not be null");
        counterService.save(title,number,chNumber,enNumber,puncNumber);
        return ResultModel.getSuccessEmptyResult();
    }

    @RequestMapping(value = "/getData",method = RequestMethod.GET)
    @ResponseBody
    public ResultModel getData(HttpServletResponse response,
                               @RequestParam(value = "offset",required = false,defaultValue = "0") int offset) {
        List<ContentModel> list = counterService.getData(offset);
        ResultModel resultModel = new ResultModel();
        resultModel.setRet(true);
        resultModel.setErrmsg(null);
        resultModel.setData(list);
        return resultModel;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        int count = counterService.getCount();
        request.setAttribute("count",count);
        return "index";
    }
}
