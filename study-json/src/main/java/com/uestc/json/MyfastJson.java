package com.uestc.json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.json4s.jackson.Json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyfastJson {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1L);
        user1.setName("xiaofang");

        User user2 = new User();
        user2.setId(1L);
        user2.setName("xiaofang");

        list.add(user1);
        list.add(user2);
        userstoString(list);
        parseUserList("[{\"id\":1,\"name\":\"xiaofang\"},{\"id\":1,\"name\":\"xiaofang\"}]");


        Group group = new Group();
        group.setId(1L);
        group.setName("amdin");
        group.setUsers(list);

        String jsonstr = JSON.toJSONString(group);
        System.out.println(jsonstr);

        JSONObject group1 =  JSON.parseObject(jsonstr);
        group1.put("name", "caier");

        String jsonstr1 = JSON.toJSONString(group1);
        System.out.println(jsonstr1);


    }

    private static void parseUserList(String jsonStr) {
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        List<User> listuser = jsonArray.toJavaList(User.class);
        Iterator iterator = listuser.iterator();
        while(iterator.hasNext()){
            User user = (User) iterator.next();
            System.out.println("..............................");
            System.out.println(user.getId());
            System.out.println(user.getName());
        }
    }

    public static void userstoString(List<User> users){
        String jsonStr = JSON.toJSONString(users);
        System.out.println(jsonStr);

    }
}




