package crudoperation.dao;

import javax.servlet.http.Cookie;

/**
 * Created by axmedbek on 7/9/17.
 */
public class CookieUtil {

    public static String getCookieUtil(Cookie[] cookies,String cookieName)
    {
        String cookieValue = "";
        if(cookies!=null)
        {
            for(Cookie cookie:cookies)
            {
                if(cookieName.equals(cookie.getName()))
                {
                    cookieValue=cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
