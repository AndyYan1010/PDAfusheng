package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/19 13:58
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckListInfo {

    /**
     * result : 1
     * receivelist : [{"isruku":"0","check_date":"2018-12-19 13:42:41","providerfullname":"河北兴盛机械有限公司","checkno":"JY20181219002","cgorderno":"PO2018090341","fpeople":"admin","id":"40288a0967c4f8f50167c4fcd8830001","ischuli":"0","songhuono":"SH20181219001"},{"isruku":"0","check_date":"2018-12-19 13:14:35","providerfullname":"河北兴盛机械有限公司","checkno":"JY20181219001","cgorderno":"PO2018090341","fpeople":"admin","id":"40288a4267c464170167c4e3236a0014","ischuli":"0","songhuono":"SH20181219001"}]
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
         * isruku : 0
         * check_date : 2018-12-19 13:42:41
         * providerfullname : 河北兴盛机械有限公司
         * checkno : JY20181219002
         * cgorderno : PO2018090341
         * fpeople : admin
         * id : 40288a0967c4f8f50167c4fcd8830001
         * ischuli : 0
         * songhuono : SH20181219001
         */

        private String isruku;
        private String check_date;
        private String providerfullname;
        private String checkno;
        private String cgorderno;
        private String fpeople;
        private String id;
        private String ischuli;
        private String songhuono;

        public String getIsruku() {
            return isruku;
        }

        public void setIsruku(String isruku) {
            this.isruku = isruku;
        }

        public String getCheck_date() {
            return check_date;
        }

        public void setCheck_date(String check_date) {
            this.check_date = check_date;
        }

        public String getProviderfullname() {
            return providerfullname;
        }

        public void setProviderfullname(String providerfullname) {
            this.providerfullname = providerfullname;
        }

        public String getCheckno() {
            return checkno;
        }

        public void setCheckno(String checkno) {
            this.checkno = checkno;
        }

        public String getCgorderno() {
            return cgorderno;
        }

        public void setCgorderno(String cgorderno) {
            this.cgorderno = cgorderno;
        }

        public String getFpeople() {
            return fpeople;
        }

        public void setFpeople(String fpeople) {
            this.fpeople = fpeople;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIschuli() {
            return ischuli;
        }

        public void setIschuli(String ischuli) {
            this.ischuli = ischuli;
        }

        public String getSonghuono() {
            return songhuono;
        }

        public void setSonghuono(String songhuono) {
            this.songhuono = songhuono;
        }
    }
}
