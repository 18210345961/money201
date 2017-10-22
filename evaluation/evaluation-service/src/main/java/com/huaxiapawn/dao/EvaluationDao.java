package com.huaxiapawn.dao;

import com.alibaba.fastjson.JSONObject;
import fgh.common.dao.BaseJdbcDao;
import fgh.common.dao.Page;
import fgh.common.util.FastJsonConvert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fgh
 * @since 2017/9/20 15:06
 */
@Repository("evaluationDao")
public class EvaluationDao extends BaseJdbcDao {

    private String getSql(){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.id,a.biz_code,a.category,a.brand,a.use_info,a.purchase_date,DATE_FORMAT(a.create_time,'%Y-%m-%d %H:%i:%s') create_time from eval_order  a ORDER BY a.create_time desc");
        return sql.toString();
    }

    public String queryEvalList(String number, int start, int limit, String status){
        Page page = new Page();
        page.setPage(start);
        page.setPagesize(limit);
        List<JSONObject> result = super.pageQueryForList(getSql(),page);
        page.setTotal(result.size());
        page.setRows(result);
        String json = FastJsonConvert.convertObjectToJSON(page);
        return json;
    }

}
