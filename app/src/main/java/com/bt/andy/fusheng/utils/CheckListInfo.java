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
     * receivelist : [{"huoyuntel":"","providerfullname":"河北兴盛机械有限公司","chaddress":"河北省邢台县宋家庄167号","id":"40288a4267f3448d0167f3456d970001","chdate":"2018-12-25 00:00:00","providerproxy":"张爱社，左利彬","huoyun":"","songhuono":"SH20181228002"}]
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
         * huoyuntel :
         * providerfullname : 河北兴盛机械有限公司
         * chaddress : 河北省邢台县宋家庄167号
         * id : 40288a4267f3448d0167f3456d970001
         * chdate : 2018-12-25 00:00:00
         * providerproxy : 张爱社，左利彬
         * huoyun :
         * songhuono : SH20181228002
         */

        private String huoyuntel;
        private String providerfullname;
        private String chaddress;
        private String id;
        private String chdate;
        private String providerproxy;
        private String huoyun;
        private String songhuono;

        public String getHuoyuntel() {
            return huoyuntel;
        }

        public void setHuoyuntel(String huoyuntel) {
            this.huoyuntel = huoyuntel;
        }

        public String getProviderfullname() {
            return providerfullname;
        }

        public void setProviderfullname(String providerfullname) {
            this.providerfullname = providerfullname;
        }

        public String getChaddress() {
            return chaddress;
        }

        public void setChaddress(String chaddress) {
            this.chaddress = chaddress;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getSonghuono() {
            return songhuono;
        }

        public void setSonghuono(String songhuono) {
            this.songhuono = songhuono;
        }
    }
}
