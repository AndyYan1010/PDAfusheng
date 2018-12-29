package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/28 9:52
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class RecAddressInfo {

    /**
     * result : 1
     * shouhuolist : [{"shaddress":"上海","shpeo":"李四","shdanwei":"复盛","id":"40288a4267df31130167df32b3c80001"}]
     * message : 列表查找成功
     */

    private int result;
    private String                message;
    private List<ShouhuolistBean> shouhuolist;

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

    public List<ShouhuolistBean> getShouhuolist() {
        return shouhuolist;
    }

    public void setShouhuolist(List<ShouhuolistBean> shouhuolist) {
        this.shouhuolist = shouhuolist;
    }

    public static class ShouhuolistBean {
        /**
         * shaddress : 上海
         * shpeo : 李四
         * shdanwei : 复盛
         * id : 40288a4267df31130167df32b3c80001
         */

        private String shaddress;
        private String shpeo;
        private String shdanwei;
        private String id;

        public String getShaddress() {
            return shaddress;
        }

        public void setShaddress(String shaddress) {
            this.shaddress = shaddress;
        }

        public String getShpeo() {
            return shpeo;
        }

        public void setShpeo(String shpeo) {
            this.shpeo = shpeo;
        }

        public String getShdanwei() {
            return shdanwei;
        }

        public void setShdanwei(String shdanwei) {
            this.shdanwei = shdanwei;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
