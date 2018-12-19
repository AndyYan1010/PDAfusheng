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
     * receivelist : [{"shpeo":"","huoyuntel":"188888","huoyunpeo":"张三","shtel":"","jlh":0,"fpeople":"admin","chdate":"2018-12-17 08:55:10","providerproxy":"汪敬华","huoyun":"测试","shfax":"","songhuono":"SH20181203001","shaddress":"","ischeck":"0","providerfullname":"大冶斯瑞尔换热器有限公司","cgorderno":"PO2018080237","tel":"0714-8755606，13872058412","id":"40288a4267717948016771900a7a0007","fax":"0714-8755609"}]
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
         * shpeo :
         * huoyuntel : 188888
         * huoyunpeo : 张三
         * shtel :
         * jlh : 0
         * fpeople : admin
         * chdate : 2018-12-17 08:55:10
         * providerproxy : 汪敬华
         * huoyun : 测试
         * shfax :
         * songhuono : SH20181203001
         * shaddress :
         * ischeck : 0
         * providerfullname : 大冶斯瑞尔换热器有限公司
         * cgorderno : PO2018080237
         * tel : 0714-8755606，13872058412
         * id : 40288a4267717948016771900a7a0007
         * fax : 0714-8755609
         */

        private String shpeo;
        private String huoyuntel;
        private String huoyunpeo;
        private String shtel;
        private int    jlh;
        private String fpeople;
        private String chdate;
        private String providerproxy;
        private String huoyun;
        private String shfax;
        private String songhuono;
        private String shaddress;
        private String ischeck;
        private String providerfullname;
        private String cgorderno;
        private String tel;
        private String id;
        private String fax;

        public String getShpeo() {
            return shpeo;
        }

        public void setShpeo(String shpeo) {
            this.shpeo = shpeo;
        }

        public String getHuoyuntel() {
            return huoyuntel;
        }

        public void setHuoyuntel(String huoyuntel) {
            this.huoyuntel = huoyuntel;
        }

        public String getHuoyunpeo() {
            return huoyunpeo;
        }

        public void setHuoyunpeo(String huoyunpeo) {
            this.huoyunpeo = huoyunpeo;
        }

        public String getShtel() {
            return shtel;
        }

        public void setShtel(String shtel) {
            this.shtel = shtel;
        }

        public int getJlh() {
            return jlh;
        }

        public void setJlh(int jlh) {
            this.jlh = jlh;
        }

        public String getFpeople() {
            return fpeople;
        }

        public void setFpeople(String fpeople) {
            this.fpeople = fpeople;
        }

        public String getChdate() {
            return chdate;
        }

        public void setChdate(String chdate) {
            this.chdate = chdate;
        }

        public String getProviderproxy() {
            return providerproxy;
        }

        public void setProviderproxy(String providerproxy) {
            this.providerproxy = providerproxy;
        }

        public String getHuoyun() {
            return huoyun;
        }

        public void setHuoyun(String huoyun) {
            this.huoyun = huoyun;
        }

        public String getShfax() {
            return shfax;
        }

        public void setShfax(String shfax) {
            this.shfax = shfax;
        }

        public String getSonghuono() {
            return songhuono;
        }

        public void setSonghuono(String songhuono) {
            this.songhuono = songhuono;
        }

        public String getShaddress() {
            return shaddress;
        }

        public void setShaddress(String shaddress) {
            this.shaddress = shaddress;
        }

        public String getIscheck() {
            return ischeck;
        }

        public void setIscheck(String ischeck) {
            this.ischeck = ischeck;
        }

        public String getProviderfullname() {
            return providerfullname;
        }

        public void setProviderfullname(String providerfullname) {
            this.providerfullname = providerfullname;
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

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }
    }
}
