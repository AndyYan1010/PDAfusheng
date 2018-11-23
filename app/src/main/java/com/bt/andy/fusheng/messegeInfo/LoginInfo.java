package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/7/17 15:36
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LoginInfo {
    /**
     * result : 1
     * loginlist : [{"create_by":"admin","fusername":"测试","sys_company_code":"A01","sys_org_code":"A01","bpm_status":"1","id":"40288ace665b7ab501665b7f9da10005","create_date":1539133382050,"fpassword":"111111","create_name":"管理员"}]
     * message : 登录成功
     */

    private int result;
    private String message;
    private List<LoginlistBean> loginlist;

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

    public List<LoginlistBean> getLoginlist() {
        return loginlist;
    }

    public void setLoginlist(List<LoginlistBean> loginlist) {
        this.loginlist = loginlist;
    }

    public static class LoginlistBean {
        /**
         * create_by : admin
         * fusername : 测试
         * sys_company_code : A01
         * sys_org_code : A01
         * bpm_status : 1
         * id : 40288ace665b7ab501665b7f9da10005
         * create_date : 1539133382050
         * fpassword : 111111
         * create_name : 管理员
         */

        private String create_by;
        private String fusername;
        private String sys_company_code;
        private String sys_org_code;
        private String bpm_status;
        private String id;
        private long create_date;
        private String fpassword;
        private String create_name;

        public String getCreate_by() {
            return create_by;
        }

        public void setCreate_by(String create_by) {
            this.create_by = create_by;
        }

        public String getFusername() {
            return fusername;
        }

        public void setFusername(String fusername) {
            this.fusername = fusername;
        }

        public String getSys_company_code() {
            return sys_company_code;
        }

        public void setSys_company_code(String sys_company_code) {
            this.sys_company_code = sys_company_code;
        }

        public String getSys_org_code() {
            return sys_org_code;
        }

        public void setSys_org_code(String sys_org_code) {
            this.sys_org_code = sys_org_code;
        }

        public String getBpm_status() {
            return bpm_status;
        }

        public void setBpm_status(String bpm_status) {
            this.bpm_status = bpm_status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getCreate_date() {
            return create_date;
        }

        public void setCreate_date(long create_date) {
            this.create_date = create_date;
        }

        public String getFpassword() {
            return fpassword;
        }

        public void setFpassword(String fpassword) {
            this.fpassword = fpassword;
        }

        public String getCreate_name() {
            return create_name;
        }

        public void setCreate_name(String create_name) {
            this.create_name = create_name;
        }
    }
}
