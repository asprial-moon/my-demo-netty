package cn.yong.demo.netty.web;

import cn.yong.demo.netty.server.NettyServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Line
 * @desc
 * @date 2022/9/27
 */
@Controller
public class NettyController {
    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "xiaohao");
        return "index";
    }
}
