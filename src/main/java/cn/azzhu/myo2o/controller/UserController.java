package cn.azzhu.myo2o.controller;

import cn.azzhu.myo2o.entity.LocalAuth;
import cn.azzhu.myo2o.entity.LogLogin;
import cn.azzhu.myo2o.entity.PersonInfo;
import cn.azzhu.myo2o.service.LocalAuthService;
import cn.azzhu.myo2o.service.LogLoginService;
import cn.azzhu.myo2o.service.PersonInfoService;
import cn.azzhu.myo2o.utils.SysConstants;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author:azzw
 * @date 2019-9-2 20:08
 */

@Controller
@RequestMapping("shop")
public class UserController {


    @Autowired
    private LocalAuthService localAuthService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private LogLoginService logLoginService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @GetMapping("login.html")
    public String tologin() {

        return "login";
    }


    @GetMapping("register.html")
    public String toRegister() {
        return "register";
    }


    @GetMapping("/main.html")
    public String toMain() {
        return "common/main";
    }

    /**
     * 登录
     *
     * @param localAuth
     * @param session
     * @return
     */
    @PostMapping("login")
    public String login(LocalAuth localAuth, HttpSession session, String code) {

        LocalAuth login2 = localAuthService.login(localAuth);
        String sessCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (code.equalsIgnoreCase(sessCode)) {
            if (login2 != null) {
                PersonInfo personInfo = new PersonInfo();
                personInfo.setUserId(login2.getUserId());
                personInfo = personInfoService.getPersonInfo(personInfo);

                session.setAttribute(SysConstants.SESSION_USER, login2);
                session.setAttribute(SysConstants.SESSION_PERSONINFO,personInfo);
                LogLogin logLogin = new LogLogin();
                logLogin.setLoginname(localAuth.getUserName() + "-" + personInfo.getName());
                logLogin.setLoginip("");
                logLogin.setLogintime(new Date());
                logLoginService.addLogLogin(logLogin);
                return "index";
            } else {
                //登录失败，回到登录页面：用户名或密码错误
                return "redirect:login.html";
            }
        } else {
            //验证码错误
            return "redirect:login.html";
        }

    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
}