/*
 * Copyright (C) 2015 earth GuangHui Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.clinic.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.clinic.model.Pager;
import com.clinic.util.LogTool;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * ResponseHandler
 * 
 * @version 2016年5月22日下午4:22:57
 * @author guangxi.zhang
 */
public class ResponseHandler {
    protected static LogTool log = LogTool.getInstance(ResponseHandler.class);
    
    /**
     * 
     * 请求处理成功
     * 
     * @version 2016年5月22日下午4:24:30
     * @author guangxi.zhang
     * @param response
     * @throws IOException
     */
    public static void responseOk(HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }
    
    /**
     * 
     * 返回xml数据
     * 
     * @version 2016年5月22日下午4:28:39
     * @author guangxi.zhang
     * @param response
     * @param xmlObj
     * @throws IOException
     */
    public static void responseXml(HttpServletResponse response, Object xmlObj) throws IOException {
        XStream xStreamForResponsetData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        String pstDataXml = xStreamForResponsetData.toXML(xmlObj);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        response.setContentType("text/xml");
        PrintWriter writer = response.getWriter();
        writer.write(pstDataXml);
        writer.flush();
        writer.close();
    }
    
    /**
     * 
     * 【请求处理成功】(
     * 
     * @param map
     * @param response
     * @throws IOException
     */
    public static void responseMapOK(Map<String, Object> map, HttpServletResponse response) throws IOException {
        // respOK(null, obj,response);
        JSONObject json = new JSONObject();
        json.put("code", 0);
        
        Iterator<String> itera = map.keySet().iterator();
        String name = "";
        while (itera.hasNext()) {
            name = itera.next();
            json.put(name, map.get(name));
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter write = response.getWriter();
        write.write(json.toJSONString());
        write.flush();
        write.close();
    }
    
    /**
     * 
     * 【请求处理成功】
     * 
     * @param obj
     * @param response
     * @throws IOException
     */
    public static void responseOK(Object obj, HttpServletResponse response) throws IOException {
        responseOk(null, obj, response);
    }
    
    @SuppressWarnings("unused")
    public static void responseOk(Pager<?, ?> page, Object obj, HttpServletResponse response) throws IOException {
        ResponsePager responsePager = null;
        if (null != page) {
            int totalRecord = 0;
            if (null != page.getList() && !page.getList().isEmpty()) {
                totalRecord = page.getList().size();
            }
            int nextPage = 0;
            if (page.getTotalPage() > page.getCurrentPage()) {
                nextPage = 1;
            }
            responsePager = new ResponsePager(page.getCurrentPage(), page.getPageSize(), page.getTotalRecord(),
                    nextPage);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("page", responsePager);
        jsonObject.put("data", obj);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        log.debug("<<<<<<<<调试输出日志:" + jsonObject.toString() + ">>>>>>>");
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }
    
    /**
     * 请求处理失败
     * 
     * @param httpStatus
     * @param msg
     * @param response
     * @return
     */
    public static Object responseError(int httpStatus, JSONObject msg, HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(msg);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(httpStatus);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 请求处理api登陆权限失败
     * 
     * @param httpStatus
     * @param msg
     * @param response
     * @return
     */
    public static Object responseApiLoginError(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage.user_not_login);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 请求处理失败
     * 
     * @param httpStatus
     * @param msg
     * @param response
     * @return
     */
    public static Object responseError(JSONObject msg, HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(msg);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 请求处理失败
     * 
     * @param httpStatus
     * @param msg
     * @param response
     * @return
     */
    public static void responseError(JSONObject msg, HttpServletResponse response, HttpServletRequest request) {
        send(msg, response, request);
    }
    
    /**
     * 【返回内容】
     * 
     * @param json
     * @param response
     * @param request
     */
    private static void send(JSONObject json, HttpServletResponse response, HttpServletRequest request) {
        log.debug("<<<<<<<<调试输出日志:" + json.toString() + ">>>>>>>");
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            response.setContentType("application/json;charset=UTF-8");
            String jsonpCallback = request.getParameter("callback");// 客户端请求参数
            if (null != jsonpCallback) {
                out.println(jsonpCallback + "(" + json.toJSONString() + ")");// 返回jsonp格式数据
            }
            else {
                out.println(json);
            }
            out.flush();
            out.close();
        }
        catch (IOException e) {
            log.error(e);
        }
    }
    
    /**
     * 服务段抛出异常处理
     * 
     * @param code
     * @param httpStatus
     * @param response
     * @return
     */
    public static Object responseServerError(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage.server_throws_exception);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(500);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 服务段抛出异常处理
     * 
     * @param code
     * @param httpStatus
     * @param response
     * @return
     */
    public static Object responseServerTimeout(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage._timeout);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * 【界面找不到】
     * 
     * @param response
     * @time:2015年12月24日 上午9:16:57
     * @version
     */
    public static void response404(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage.error_404);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(404);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 【请求方法找不到】
     * 
     * @param response
     * @time:2015年12月24日 上午9:17:19
     * @version
     */
    public static void response405(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage.error_405);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(405);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 【参数匹配不上】
     * 
     * @param response
     * @time:2016年1月6日 上午11:05:37
     * @version
     */
    public static void response400(HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.putAll(ResponseMessage.error_400);
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(400);
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void responseException(int exceptionType, String msg, HttpServletResponse response) {
        try {
            JSONObject json = new JSONObject();
            json.put("code", exceptionType);
            json.put("msg", msg);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter write = response.getWriter();
            log.debug("<<<<<<<<调试输出日志:" + json.toString() + ">>>>>>>");
            write.write(json.toJSONString());
            write.flush();
            write.close();
        }
        catch (IOException e) {
            log.error(e);
        }
    }
}
