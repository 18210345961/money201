package com.huaxiapawn.api;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author fgh
 * @since 2017/9/20 13:52
 */
@Path("/evalService")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public interface EvaluationService {

    @GET
    @Path("/list/{number}/{start:\\d+}/{limit:\\d+}/{status}")
    @ResponseBody
    String queryEvalList(@PathParam(value = "number") String number, @PathParam(value = "start") int start,
                                @PathParam(value = "limit") int limit, @PathParam(value = "status") String status);


}
