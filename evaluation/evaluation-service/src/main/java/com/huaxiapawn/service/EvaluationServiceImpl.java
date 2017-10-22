package com.huaxiapawn.service;

import com.huaxiapawn.api.EvaluationService;
import com.huaxiapawn.dao.EvaluationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fgh
 * @since 2017/9/20 14:56
 */
@Service("evalService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = EvaluationService.class, protocol = {"rest", "dubbo"})
public class EvaluationServiceImpl implements EvaluationService {

    private static  final Logger logger = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    @Autowired
    EvaluationDao evaluationDao;

//    @RequestMapping(value = "/list",method = RequestMethod.GET,consumes="application/json")
    @Override
    public String queryEvalList(String number, int start, int limit, String status) {
        logger.info("查询估价列表,number="+number+",start="+start+",limit="+limit+",status="+status);
        return evaluationDao.queryEvalList(number,start,limit,status);
    }

}
