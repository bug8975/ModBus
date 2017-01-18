package com.tjmj.Dao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/11.
 */
@RestController
public class WebController {

@RequestMapping("/login")
public String Userlogin()
{

    return "index";

}



}
