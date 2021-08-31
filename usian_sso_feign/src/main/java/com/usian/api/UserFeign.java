package com.usian.api;

import com.usian.pojo.User;
import com.usian.vo.LoginUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("usian-sso-service")
public interface UserFeign {

    @RequestMapping("user/getUserByToken/{token}")
    public User getUserByToken(@PathVariable("token") String token);

    @RequestMapping("user/userLogin")
    public LoginUserVO userLogin(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping("user/checkUserInfo/{checkValue}/{checkFlag}")
    public Boolean checkUserInfo(@PathVariable("checkValue") String checkValue, @PathVariable("checkFlag") Integer checkFlag);

    @RequestMapping("user/userRegister")
    public Boolean userRegister(@RequestBody User user);
}
