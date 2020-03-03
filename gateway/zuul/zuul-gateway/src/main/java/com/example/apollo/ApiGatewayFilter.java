package com.example.apollo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: ApiGatewayFilter
 * @Package: com.example.apollo
 * @Description: TODO（添加描述）
 * @Author: monkjavaer
 * @Date: 2020/3/3 22:03
 * @Version: V1.0
 */
@Slf4j
@Component
public class ApiGatewayFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * 返回 "pre" 表示请求在被路由之前执行 ApiGetwayFilter
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要执行,这里默认拦截所有请求
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("网关服务收到请求url={},方法类型={}", request.getRequestURL().toString(), request.getMethod());
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            log.error("请求缺少token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }
        return null;
    }
}
