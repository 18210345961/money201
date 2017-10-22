package com.huaxiapawn.controller;

import com.huaxiapawn.api.EvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fgh
 * @since 2017/9/21 22:19
 */
@Controller
@RequestMapping("/eval")
@Api("抢单api")
public class EvalController {

    private  static final Logger logger = LoggerFactory.getLogger(EvalController.class);

    @Autowired
    private EvaluationService evaluationService;

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json")
    @ApiOperation(value = "查询待抢单列表",httpMethod = "GET",response = String.class)
    public  String queryEvalList(@RequestParam  String number, @RequestParam String start, @RequestParam String limit, @RequestParam String status){
        logger.info("查询估价列表,number="+number+",start="+start+",limit="+limit+",status="+status);
        String json =  evaluationService.queryEvalList(number,Integer.parseInt(start),Integer.parseInt(limit),status);
        logger.info("查询估价列表,result="+json);
        return json;
    }
}
