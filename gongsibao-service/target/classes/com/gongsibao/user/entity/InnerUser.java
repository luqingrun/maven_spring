package com.gongsibao.user.entity;

import com.gongsibao.common.util.json.JsonUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by luqingrun on 16/3/22.
 */
public class InnerUser implements java.io.Serializable {

    private static final long serialVersionUID = 3041454089207704926L;
    private Long id;
    private String name;
    private String mobile;
    private String realName;
    private String passwd;
    private String mail;
    private Date addTime;
    private String aaaaa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAaaaa() {
        return aaaaa;
    }

    public void setAaaaa(String aaaaa) {
        this.aaaaa = aaaaa;
    }

    public static void main(String[] args) {
        String json = "" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"luqingrun1\",\n" +
                "        \"mobile\": \"13331156897\",\n" +
                "        \"realName\": \"陆庆润\",\n" +
                "        \"passwd\": \"密码\",\n" +
                "        \"aaaaa\": \"密码\",\n" +
                "        \"passwd2\": \"密码\",\n" +
                "        \"mail\": \"13331156897\",\n" +
                "        \"addTime\": \"2016-03-29 15:47:08\"\n" +
                "    } "+
                "";

//        List<Map> list = JsonUtils.jsonToList(json, Map.class);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        List<InnerUser> innerUserList = JsonUtils.jsonToList(json, InnerUser.class);
//        System.out.println(innerUserList.getClass());
//        for (int i = 0; i < innerUserList.size(); i++) {
//            System.out.println(innerUserList.get(i).getAaaaa());
//        }

        System.out.println(JsonUtils.jsonToObject(json,InnerUser.class));
    }
}
