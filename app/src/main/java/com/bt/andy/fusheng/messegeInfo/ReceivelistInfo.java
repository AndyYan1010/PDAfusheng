package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/3 9:50
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class ReceivelistInfo {

    /**
     * result : 1
     * receivelist : [{"orderno":"PO2018100008","address":"闵行区莲花南路2129弄118号8座","providerfullname":"星域控制工程(上海)有限公司","jlh":15326355,"cgorderno":"OR18-12-12008","tel":"13764903331，33505868","id":"3200D091-02DB-47F8-A374-E732DF07BBEC","providerproxy":"熊建","fax":"021-33505738","lrsj":1538977995493},{"orderno":"PO2018090341","address":"河北省邢台县宋家庄167号","providerfullname":"河北兴盛机械有限公司","jlh":15321803,"cgorderno":"OR18-12-140013","tel":"0319-2764092，13818978466(SH)","id":"4EAE6A99-EEAC-4454-8546-E4BF73E7E41B","providerproxy":"张爱社，左利彬","fax":"0319-2764966","lrsj":1538291686450},{"orderno":"PO2018080237","address":"湖北省大冶市经济开发区西北工业园","receiver":"李四","receivename":"235638134@qq.com","jlh":15186077,"fnote":"备料:2018-11-01 16:04:45;备料:2018-11-02 16:04:57;备料:2018-11-03 16:05:07;备料:2018-10-25 16:05:39;备料:2018-11-30 16:06:14;备料:2018-11-12 16:10:12;生产:2018-11-19 16:13:29;外协:2018-11-27 16:13:39;加工:2018-12-25 16:13:47;喷涂:2018-11-13 16:13:57","providerproxy":"汪敬华","issonghuo":"0","lrsj":1537338935000,"filename":"","providerfullname":"大冶斯瑞尔换热器有限公司","cgorderno":"OR18-11-14001","tel":"0714-8755606，13872058412","id":"74551268-B68A-4E21-8D47-E405BA39F2F3","fax":"0714-8755609","rtel":"1888888","rfax":"23333","fcheckstatus":"2","raddress":"南通1"}]
     * message : 列表查找成功
     */

    private int result;
    private String                message;
    private List<ReceivelistBean> receivelist;

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

    public List<ReceivelistBean> getReceivelist() {
        return receivelist;
    }

    public void setReceivelist(List<ReceivelistBean> receivelist) {
        this.receivelist = receivelist;
    }

    public static class ReceivelistBean {
        /**
         * orderno : PO2018100008
         * address : 闵行区莲花南路2129弄118号8座
         * providerfullname : 星域控制工程(上海)有限公司
         * jlh : 15326355
         * cgorderno : OR18-12-12008
         * tel : 13764903331，33505868
         * id : 3200D091-02DB-47F8-A374-E732DF07BBEC
         * providerproxy : 熊建
         * fax : 021-33505738
         * lrsj : 1538977995493
         * receiver : 李四
         * receivename : 235638134@qq.com
         * fnote : 备料:2018-11-01 16:04:45;备料:2018-11-02 16:04:57;备料:2018-11-03 16:05:07;备料:2018-10-25 16:05:39;备料:2018-11-30 16:06:14;备料:2018-11-12 16:10:12;生产:2018-11-19 16:13:29;外协:2018-11-27 16:13:39;加工:2018-12-25 16:13:47;喷涂:2018-11-13 16:13:57
         * issonghuo : 0
         * filename :
         * rtel : 1888888
         * rfax : 23333
         * fcheckstatus : 2
         * raddress : 南通1
         */

        private String orderno;
        private String address;
        private String providerfullname;
        private int    jlh;
        private String cgorderno;
        private String tel;
        private String id;
        private String providerproxy;
        private String fax;
        private long   lrsj;
        private String receiver;
        private String receivename;
        private String fnote;
        private String issonghuo;
        private String filename;
        private String rtel;
        private String rfax;
        private String fcheckstatus;
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

        public String getCgorderno() {
            return cgorderno;
        }

        public void setCgorderno(String cgorderno) {
            this.cgorderno = cgorderno;
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

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public long getLrsj() {
            return lrsj;
        }

        public void setLrsj(long lrsj) {
            this.lrsj = lrsj;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getReceivename() {
            return receivename;
        }

        public void setReceivename(String receivename) {
            this.receivename = receivename;
        }

        public String getFnote() {
            return fnote;
        }

        public void setFnote(String fnote) {
            this.fnote = fnote;
        }

        public String getIssonghuo() {
            return issonghuo;
        }

        public void setIssonghuo(String issonghuo) {
            this.issonghuo = issonghuo;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getRtel() {
            return rtel;
        }

        public void setRtel(String rtel) {
            this.rtel = rtel;
        }

        public String getRfax() {
            return rfax;
        }

        public void setRfax(String rfax) {
            this.rfax = rfax;
        }

        public String getFcheckstatus() {
            return fcheckstatus;
        }

        public void setFcheckstatus(String fcheckstatus) {
            this.fcheckstatus = fcheckstatus;
        }

        public String getRaddress() {
            return raddress;
        }

        public void setRaddress(String raddress) {
            this.raddress = raddress;
        }
    }
}
