package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping("toquerylist")
    public String  toquerylist(){
        return "showList";
    }


    @RequestMapping("queryUserdata")
    @ResponseBody
    public  Map<String,Object>  queryUserdata(Integer pageSize, Integer start, User user){
        Map<String,Object> man=  userService.queryUserdata(pageSize,start,user);
    return  man;
    }

    @RequestMapping("findTree")
    @ResponseBody
    public List<Tree> findTree(HttpServletResponse resp, Tree tree){
        List<Tree> List = userService.findTree(0);
        List<Tree> parentList = parentList(List);
        return parentList;
    }


    public List<Tree> parentList(List<Tree> list){
        List<Tree> childList = new ArrayList<Tree>();
        for(int i = 0; i < list.size(); i++){
            Tree tree = list.get(i);
            List<Tree> findTree =userService.findTree(tree.getId());
            if(findTree.size()>0){
                // 当前 子节点的集合
                List<Tree> getchirdTree = getchirdTree(findTree);
                // 将子节点装进集合中
                tree.setNodes(getchirdTree);
                childList.add(tree);
            }else{
                childList.add(tree);
            }
        }
        return childList;
    }


    public List<Tree> getchirdTree(List<Tree> list){
        List<Tree> childList = new ArrayList<Tree>();
        for(int i = 0; i < list.size(); i++){
            Tree tree = list.get(i);
            List<Tree> findTree =userService.findTree(tree.getId());
            //判断他有没有子节点
            if(findTree.size()>0){
                // 当前 子节点的集合
                List<Tree> getchirdTree = getchirdTree(findTree);
                // 将子节点装进集合中
                tree.setNodes(getchirdTree);
                childList.add(tree);
            }else{
                childList.add(tree);
            }
        }
        return childList;
    }
}
