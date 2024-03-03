package net.cctv3.chnqoodiaryservice.filter;

import com.alibaba.fastjson.JSON;
import net.cctv3.chnqoodiaryservice.constants.Status;
import net.cctv3.chnqoodiaryservice.constants.StringUtils;
import net.cctv3.chnqoodiaryservice.controller.JsonResponser;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@CrossOrigin
public class WebFilters implements HandlerInterceptor {
    private Logger logger = LogManager.getLogger(WebFilters.class);
    public final static String[] blackList = new String[]{
            "fileUploader", "favicon.ico", "error"
    };

    private boolean isWhiteURI(String uri) {
        for(String s: blackList) {
            if(uri.contains(s)) {
                return true;
            }
        }
        return false;
    };

    private boolean checkTS(String t, String s) {
        boolean result = false;
        if(StringUtils.isEmpty(t) || StringUtils.isEmpty(s)) {
            result =  false;
        }
        else {
            long server = System.currentTimeMillis();
            long client = Long.parseLong(t);
            if(server - client > 10 * 1000) {
                result = false;
            }
            else {
                // return md5.convert(utf8.encode('Chnqoo@t:${s}')).toString();
                result = s.equals(DigestUtils.md5Hex("Chnqoo@t:" + t));
            }
        }
        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;
        if (request.getMethod().equals("OPTIONS") || isWhiteURI(request.getRequestURI())) {
            return true;
        }
        else {
            String t = request.getHeader("t");
            String s = request.getHeader("s");
            logger.debug(request.getRequestURL() + t + ": " + s);
            result = checkTS(t, s);
            if(!result) {
                response.setContentType("application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(new JsonResponser(Status.TS_CHECKED_MD5.getCode()).ok());
            }
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}