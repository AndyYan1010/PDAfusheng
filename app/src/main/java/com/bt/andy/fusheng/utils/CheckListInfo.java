package com.bt.andy.fusheng.utils;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/27 15:37
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckListInfo {

    /**
     * result : 1
     * inspectionlist : [{"orderno":"PO2018100008","address":"闵行区莲花南路2129弄118号8座","providerfullname":"星域控制工程(上海)有限公司","jlh":15326355,"tel":"13764903331，33505868","id":"3200D091-02DB-47F8-A374-E732DF07BBEC","providerproxy":"熊建"},{"orderno":"PO2018090341","address":"河北省邢台县宋家庄167号","providerfullname":"河北兴盛机械有限公司","jlh":15321803,"tel":"0319-2764092，13818978466(SH)","id":"4EAE6A99-EEAC-4454-8546-E4BF73E7E41B","providerproxy":"张爱社，左利彬"},{"orderno":"PO2018080237","address":"湖北省大冶市经济开发区西北工业园","receiver":"李四","providerfullname":"大冶斯瑞尔换热器有限公司","jlh":15186077,"tel":"0714-8755606，13872058412","id":"74551268-B68A-4E21-8D47-E405BA39F2F3","providerproxy":"汪敬华","rtel":"1888888","raddress":"南通1"}]
     * message : 列表查找成功
     */

    private int result;
    private String                   message;
    private List<InspectionlistBean> inspectionlist;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<InspectionlistBean> getInspectionlist() {
        return inspectionlist;
    }

    public void setInspectionlist(List<InspectionlistBean> inspectionlist) {
        this.inspectionlist = inspectionlist;
    }

    public static class InspectionlistBean {
        /**
         * orderno : PO2018100008
         * address : 闵行区莲花南路2129弄118号8座
         * providerfullname : 星域控制工程(上海)有限公司
         * jlh : 15326355
         * tel : 13764903331，33505868
         * id : 3200D091-02DB-47F8-A374-E732DF07BBEC
         * providerproxy : 熊建
         * receiver : 李四
         * rtel : 1888888
         * raddress : 南通1
         */

        private String orderno;
        private String address;
        private String providerfullname;
        private int    jlh;
        private String tel;
        private String id;
        private String providerproxy;
        private String receiver;
        private String rtel;
        private String raddress;

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProviderfullname() {
            return providerfullname;
        }

        public void setProviderfullname(String providerfullname) {
            this.providerfullname = providerfullname;
        }

        public int getJlh() {
            return jlh;
        }

        public void setJlh(int jlh) {
            this.jlh = jlh;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProviderproxy() {
            return providerproxy;
        }

        public void setProviderproxy(String providerproxy) {
            this.providerproxy = providerproxy;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getRtel() {
            return rtel;
        }

        public void setRtel(String rtel) {
            this.rtel = rtel;
        }

        public String getRaddress() {
            return raddress;
        }

        public void setRaddress(String raddress) {
            this.raddress = raddress;
        }
    }
}
