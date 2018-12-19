package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/19 15:02
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckDetailInfo {

    /**
     * result : 1
     * shelvesdetail : [{"isruku":"0","shelvesentry":[{"badnum":1,"reason":"","isruku":"0","crknum":0,"automemo":"物管库:2个,进料库:0个,服务库:0个,半成品库:0个,转口贸易库:0个,服务旧品库:0个,旧品处理库:0个,在途:10 个,请购:1个,物料库180天内月均出库数:4.5个。超过90天库存数量:","checknum":1,"badrknum":0,"cadlist":"KP1905 R1; KP1920 R5; P40B1 R1;","cadno":"KP1920","sfilename":"MP0612 R2.pdf","units":" 个","ischuli":"1","version":"R5","songhuono":"SH20181219001","songhuonum":1,"djjlh":"15321806","checkno":"JY20181219002","cgorderno":"PO2018090341","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","id":"40288a0967c4f8f50167c4fcd8830002","checkid":"40288a0967c4f8f50167c4fcd8830001","goodnum":0}],"check_date":"2018-12-19 13:42:41","providerfullname":"河北兴盛机械有限公司","checkno":"JY20181219002","cgorderno":"PO2018090341","fpeople":"admin","id":"40288a0967c4f8f50167c4fcd8830001","ischuli":"0","songhuono":"SH20181219001"}]
     * message : 详情查看成功
     */

    private int result;
    private String                  message;
    private List<ShelvesdetailBean> shelvesdetail;

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

    public List<ShelvesdetailBean> getShelvesdetail() {
        return shelvesdetail;
    }

    public void setShelvesdetail(List<ShelvesdetailBean> shelvesdetail) {
        this.shelvesdetail = shelvesdetail;
    }

    public static class ShelvesdetailBean {
        /**
         * isruku : 0
         * shelvesentry : [{"badnum":1,"reason":"","isruku":"0","crknum":0,"automemo":"物管库:2个,进料库:0个,服务库:0个,半成品库:0个,转口贸易库:0个,服务旧品库:0个,旧品处理库:0个,在途:10 个,请购:1个,物料库180天内月均出库数:4.5个。超过90天库存数量:","checknum":1,"badrknum":0,"cadlist":"KP1905 R1; KP1920 R5; P40B1 R1;","cadno":"KP1920","sfilename":"MP0612 R2.pdf","units":" 个","ischuli":"1","version":"R5","songhuono":"SH20181219001","songhuonum":1,"djjlh":"15321806","checkno":"JY20181219002","cgorderno":"PO2018090341","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","id":"40288a0967c4f8f50167c4fcd8830002","checkid":"40288a0967c4f8f50167c4fcd8830001","goodnum":0}]
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
        private String                 check_date;
        private String                 providerfullname;
        private String                 checkno;
        private String                 cgorderno;
        private String                 fpeople;
        private String                 id;
        private String                 ischuli;
        private String                 songhuono;
        private List<ShelvesentryBean> shelvesentry;

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

        public List<ShelvesentryBean> getShelvesentry() {
            return shelvesentry;
        }

        public void setShelvesentry(List<ShelvesentryBean> shelvesentry) {
            this.shelvesentry = shelvesentry;
        }

        public static class ShelvesentryBean {
            /**
             * badnum : 1
             * reason :
             * isruku : 0
             * crknum : 0
             * automemo : 物管库:2个,进料库:0个,服务库:0个,半成品库:0个,转口贸易库:0个,服务旧品库:0个,旧品处理库:0个,在途:10 个,请购:1个,物料库180天内月均出库数:4.5个。超过90天库存数量:
             * checknum : 1
             * badrknum : 0
             * cadlist : KP1905 R1; KP1920 R5; P40B1 R1;
             * cadno : KP1920
             * sfilename : MP0612 R2.pdf
             * units :  个
             * ischuli : 1
             * version : R5
             * songhuono : SH20181219001
             * songhuonum : 1
             * djjlh : 15321806
             * checkno : JY20181219002
             * cgorderno : PO2018090341
             * cadLibjlh : https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf
             * id : 40288a0967c4f8f50167c4fcd8830002
             * checkid : 40288a0967c4f8f50167c4fcd8830001
             * goodnum : 0
             */

            private int badnum;
            private String reason;
            private String isruku;
            private int    crknum;
            private String automemo;
            private int    checknum;
            private int    badrknum;
            private String cadlist;
            private String cadno;
            private String sfilename;
            private String units;
            private String ischuli;
            private String version;
            private String songhuono;
            private int    songhuonum;
            private String djjlh;
            private String checkno;
            private String cgorderno;
            private String cadLibjlh;
            private String id;
            private String checkid;
            private int    goodnum;

            public int getBadnum() {
                return badnum;
            }

            public void setBadnum(int badnum) {
                this.badnum = badnum;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getIsruku() {
                return isruku;
            }

            public void setIsruku(String isruku) {
                this.isruku = isruku;
            }

            public int getCrknum() {
                return crknum;
            }

            public void setCrknum(int crknum) {
                this.crknum = crknum;
            }

            public String getAutomemo() {
                return automemo;
            }

            public void setAutomemo(String automemo) {
                this.automemo = automemo;
            }

            public int getChecknum() {
                return checknum;
            }

            public void setChecknum(int checknum) {
                this.checknum = checknum;
            }

            public int getBadrknum() {
                return badrknum;
            }

            public void setBadrknum(int badrknum) {
                this.badrknum = badrknum;
            }

            public String getCadlist() {
                return cadlist;
            }

            public void setCadlist(String cadlist) {
                this.cadlist = cadlist;
            }

            public String getCadno() {
                return cadno;
            }

            public void setCadno(String cadno) {
                this.cadno = cadno;
            }

            public String getSfilename() {
                return sfilename;
            }

            public void setSfilename(String sfilename) {
                this.sfilename = sfilename;
            }

            public String getUnits() {
                return units;
            }

            public void setUnits(String units) {
                this.units = units;
            }

            public String getIschuli() {
                return ischuli;
            }

            public void setIschuli(String ischuli) {
                this.ischuli = ischuli;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getSonghuono() {
                return songhuono;
            }

            public void setSonghuono(String songhuono) {
                this.songhuono = songhuono;
            }

            public int getSonghuonum() {
                return songhuonum;
            }

            public void setSonghuonum(int songhuonum) {
                this.songhuonum = songhuonum;
            }

            public String getDjjlh() {
                return djjlh;
            }

            public void setDjjlh(String djjlh) {
                this.djjlh = djjlh;
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

            public String getCadLibjlh() {
                return cadLibjlh;
            }

            public void setCadLibjlh(String cadLibjlh) {
                this.cadLibjlh = cadLibjlh;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCheckid() {
                return checkid;
            }

            public void setCheckid(String checkid) {
                this.checkid = checkid;
            }

            public int getGoodnum() {
                return goodnum;
            }

            public void setGoodnum(int goodnum) {
                this.goodnum = goodnum;
            }
        }
    }
}
