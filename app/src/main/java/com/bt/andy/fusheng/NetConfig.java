package com.bt.andy.fusheng;

/**
 * @创建者 AndyYan
 * @创建时间 2018/8/28 8:48
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class NetConfig {
    //服务器总地址
    public static String ROOT          = "http://192.168.10.137:8081/";
    //测试地址
    public static String TESTURL       = "http://192.168.10.137:8081/";
    //登录
    public static String LOGIN         = ROOT + "login";
    //查找校验单列表
    public static String RECEIVELIST   = ROOT + "receivelist";
    //查找校验单详情
    public static String RECEIVEDETAIL = ROOT + "receivedetail";
    //提交校验单
    public static String UPDATERECEIVE = ROOT + "updatereceive";


    //获取成品列表
    public static String SHELVESLIST   = ROOT + "shelveslist";
    //成品详情
    public static String SHELVESLISTDE = ROOT + "shelveslistde";

    //查看仓库
    public static String SELECTWAREHOUSE = ROOT + "selectwarehouse";
    //查看仓位
    public static String SELECTPOSITIONS = ROOT + "selectpositions";

}
