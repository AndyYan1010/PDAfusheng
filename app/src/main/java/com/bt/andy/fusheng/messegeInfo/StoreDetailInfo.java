package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/21 16:02
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class StoreDetailInfo {

    /**
     * result : 1
     * warehouselist : [{"housename":"仓库1111111111111","id":"402880e767442c780167442d59c80001","housecode":"001"},{"housename":"仓库b,1","id":"40288a4267728d6f0167728e88460002","housecode":"002"}]
     * message : 仓库查找成功
     */

    private int result;
    private String                  message;
    private List<WarehouselistBean> warehouselist;

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

    public List<WarehouselistBean> getWarehouselist() {
        return warehouselist;
    }

    public void setWarehouselist(List<WarehouselistBean> warehouselist) {
        this.warehouselist = warehouselist;
    }

    public static class WarehouselistBean {
        /**
         * housename : 仓库1111111111111
         * id : 402880e767442c780167442d59c80001
         * housecode : 001
         */

        private String housename;
        private String id;
        private String housecode;

        public String getHousename() {
            return housename;
        }

        public void setHousename(String housename) {
            this.housename = housename;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHousecode() {
            return housecode;
        }

        public void setHousecode(String housecode) {
            this.housecode = housecode;
        }
    }
}
