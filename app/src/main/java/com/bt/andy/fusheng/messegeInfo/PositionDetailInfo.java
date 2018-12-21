package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/21 16:06
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class PositionDetailInfo {

    /**
     * result : 1
     * positionslist : [{"fname":"仓位bbbbb","id":"402880e767442c780167442d75110003","fcode":"001"},{"fname":"仓位aa","id":"40288a4267728d6f0167728ed1c70004","fcode":"002"}]
     * message : 仓位查找成功
     */

    private int result;
    private String                  message;
    private List<PositionslistBean> positionslist;

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

    public List<PositionslistBean> getPositionslist() {
        return positionslist;
    }

    public void setPositionslist(List<PositionslistBean> positionslist) {
        this.positionslist = positionslist;
    }

    public static class PositionslistBean {
        /**
         * fname : 仓位bbbbb
         * id : 402880e767442c780167442d75110003
         * fcode : 001
         */

        private String fname;
        private String id;
        private String fcode;

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFcode() {
            return fcode;
        }

        public void setFcode(String fcode) {
            this.fcode = fcode;
        }
    }
}
