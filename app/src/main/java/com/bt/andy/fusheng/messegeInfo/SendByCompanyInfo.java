package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/28 9:56
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SendByCompanyInfo {

    /**
     * result : 1
     * huoyunlist : [{"huoyunname":"测试","huoyuntel":"188888","huoyunpeo":"张三","id":"40288a0966ccc4820166ccc5528e0001"}]
     * message : 货运查找成功
     */

    private int result;
    private String               message;
    private List<HuoyunlistBean> huoyunlist;

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

    public List<HuoyunlistBean> getHuoyunlist() {
        return huoyunlist;
    }

    public void setHuoyunlist(List<HuoyunlistBean> huoyunlist) {
        this.huoyunlist = huoyunlist;
    }

    public static class HuoyunlistBean {
        /**
         * huoyunname : 测试
         * huoyuntel : 188888
         * huoyunpeo : 张三
         * id : 40288a0966ccc4820166ccc5528e0001
         */

        private String huoyunname;
        private String huoyuntel;
        private String huoyunpeo;
        private String id;

        public String getHuoyunname() {
            return huoyunname;
        }

        public void setHuoyunname(String huoyunname) {
            this.huoyunname = huoyunname;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
