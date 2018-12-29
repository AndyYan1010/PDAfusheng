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
    public static String ROOT    = "http://172.16.52.100:8081/";
    //测试地址
    public static String TESTURL = "http://172.16.52.100:8081/";
    //登录
    public static String LOGIN   = ROOT + "login";


    //查找校验单列表
    public static String SELECTCGORDEROR = ROOT + "selectcgorderor";
    //查找校验单详情
    public static String SELECTCGORDER   = ROOT + "selectcgorder";
    //提交校验单
    public static String INSERTSONGHUO   = ROOT + "insertsonghuo";

    //查找收货单位
    public static String SELECTSH     = ROOT + "selectsh";
    //查找货运公司
    public static String SELECTHUOYUN = ROOT + "selecthuoyun";


    //品质检验列表
    public static String RECEIVELIST   = ROOT + "receivelist";
    //品质检验详情
    public static String RECEIVELISTDE = ROOT + "receivelistde";
    //提交质检单
    public static String UPDATERECEIVE = ROOT + "updatereceive";


    //获取成品列表
    public static String SHELVESLIST   = ROOT + "shelveslist";
    //成品详情
    public static String SHELVESLISTDE = ROOT + "shelveslistde";
    //更新详情
    public static String UPDATESHELVES = ROOT + "updateshelves";

    //查看仓库
    public static String SELECTWAREHOUSE = ROOT + "selectwarehouse";
    //查看仓位
    public static String SELECTPOSITIONS = ROOT + "selectpositions";

}
