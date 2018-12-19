package com.bt.andy.fusheng.messegeInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/3 10:49
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class ReceiveDetailInfo {

    /**
     * result : 1
     * receivelist : [{"shpeo":"","shdanwei":"","huoyuntel":"","huoyunpeo":"","chaddress":"闵行区莲花南路2129弄118号8座","jlh":0,"fpeople":"admin","chdate":"2018-11-13","providerproxy":"熊建","huoyun":"","songhuono":"SH20181218001","shaddress":"","ischeck":"0","providerfullname":"星域控制工程(上海)有限公司","cgorderno":"PO2018100008","receiveentrylist":[{"num":1,"sfilename":"S3113040 R0.pdf","fnote":"","sjnum":1,"isstatus":"1","units":" 个","songhuono":"SH20181218001","ischeck":"1","djjlh":"15326329","hxcnum":0,"isrk":"1","providerfullname":"星域控制工程(上海)有限公司","id":"40288a4267c055a30167c059f30c0005","rknumber":0,"respectarrivedate":"2018-12-11","automemo":"物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:","isbianji":"1","cadlist":"S3113040 R0;","cadno":"S3113040","songhuoid":"40288a4267c055a30167c059f30c0004","version":"R0","cnum":1,"songhuonum":1,"cgorderno":"PO2018100008","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","goodnum":0},{"num":1,"sfilename":"S3113040 R0.pdf","fnote":"","sjnum":1,"isstatus":"1","units":" 个","songhuono":"SH20181218001","ischeck":"1","djjlh":"15326327","hxcnum":0,"isrk":"1","providerfullname":"星域控制工程(上海)有限公司","id":"40288a4267c055a30167c059f30d0006","rknumber":0,"respectarrivedate":"2018-11-27","automemo":"物管库:4 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:8 个,请购:1 个,物料库180天内月均出库数:2.0 个。超过90天库存数量:物管库(3),","isbianji":"1","cadlist":"S3113039 R0;","cadno":"S3113039","songhuoid":"40288a4267c055a30167c059f30c0004","version":"R0","cnum":1,"songhuonum":1,"cgorderno":"PO2018100008","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","goodnum":1}],"id":"40288a4267c055a30167c059f30c0004"}]
     * message : 详情查找成功
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
         * shdanwei :
         * huoyuntel :
         * huoyunpeo :
         * chaddress : 闵行区莲花南路2129弄118号8座
         * jlh : 0
         * fpeople : admin
         * chdate : 2018-11-13
         * providerproxy : 熊建
         * huoyun :
         * songhuono : SH20181218001
         * shaddress :
         * ischeck : 0
         * providerfullname : 星域控制工程(上海)有限公司
         * cgorderno : PO2018100008
         * receiveentrylist : [{"num":1,"sfilename":"S3113040 R0.pdf","fnote":"","sjnum":1,"isstatus":"1","units":" 个","songhuono":"SH20181218001","ischeck":"1","djjlh":"15326329","hxcnum":0,"isrk":"1","providerfullname":"星域控制工程(上海)有限公司","id":"40288a4267c055a30167c059f30c0005","rknumber":0,"respectarrivedate":"2018-12-11","automemo":"物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:","isbianji":"1","cadlist":"S3113040 R0;","cadno":"S3113040","songhuoid":"40288a4267c055a30167c059f30c0004","version":"R0","cnum":1,"songhuonum":1,"cgorderno":"PO2018100008","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","goodnum":0},{"num":1,"sfilename":"S3113040 R0.pdf","fnote":"","sjnum":1,"isstatus":"1","units":" 个","songhuono":"SH20181218001","ischeck":"1","djjlh":"15326327","hxcnum":0,"isrk":"1","providerfullname":"星域控制工程(上海)有限公司","id":"40288a4267c055a30167c059f30d0006","rknumber":0,"respectarrivedate":"2018-11-27","automemo":"物管库:4 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:8 个,请购:1 个,物料库180天内月均出库数:2.0 个。超过90天库存数量:物管库(3),","isbianji":"1","cadlist":"S3113039 R0;","cadno":"S3113039","songhuoid":"40288a4267c055a30167c059f30c0004","version":"R0","cnum":1,"songhuonum":1,"cgorderno":"PO2018100008","cadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","goodnum":1}]
         * id : 40288a4267c055a30167c059f30c0004
         */

        private String shpeo;
        private String                     shdanwei;
        private String                     huoyuntel;
        private String                     huoyunpeo;
        private String                     chaddress;
        private int                        jlh;
        private String                     fpeople;
        private String                     chdate;
        private String                     providerproxy;
        private String                     huoyun;
        private String                     songhuono;
        private String                     shaddress;
        private String                     ischeck;
        private String                     providerfullname;
        private String                     cgorderno;
        private String                     id;
        private List<ReceiveentrylistBean> receiveentrylist;

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

        public String getChaddress() {
            return chaddress;
        }

        public void setChaddress(String chaddress) {
            this.chaddress = chaddress;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ReceiveentrylistBean> getReceiveentrylist() {
            return receiveentrylist;
        }

        public void setReceiveentrylist(List<ReceiveentrylistBean> receiveentrylist) {
            this.receiveentrylist = receiveentrylist;
        }

        public static class ReceiveentrylistBean {
            /**
             * num : 1
             * sfilename : S3113040 R0.pdf
             * fnote :
             * sjnum : 1
             * isstatus : 1
             * units :  个
             * songhuono : SH20181218001
             * ischeck : 1
             * djjlh : 15326329
             * hxcnum : 0
             * isrk : 1
             * providerfullname : 星域控制工程(上海)有限公司
             * id : 40288a4267c055a30167c059f30c0005
             * rknumber : 0
             * respectarrivedate : 2018-12-11
             * automemo : 物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:
             * isbianji : 1
             * cadlist : S3113040 R0;
             * cadno : S3113040
             * songhuoid : 40288a4267c055a30167c059f30c0004
             * version : R0
             * cnum : 1
             * songhuonum : 1
             * cgorderno : PO2018100008
             * cadLibjlh : https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf
             * goodnum : 0
             */

            private int num;
            private String sfilename;
            private String fnote;
            private int    sjnum;
            private String isstatus;
            private String units;
            private String songhuono;
            private String ischeck;
            private String djjlh;
            private int    hxcnum;
            private String isrk;
            private String providerfullname;
            private String id;
            private int    rknumber;
            private String respectarrivedate;
            private String automemo;
            private String isbianji;
            private String cadlist;
            private String cadno;
            private String songhuoid;
            private String version;
            private int    cnum;
            private int    songhuonum;
            private String cgorderno;
            private String cadLibjlh;
            private int    goodnum;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getSfilename() {
                return sfilename;
            }

            public void setSfilename(String sfilename) {
                this.sfilename = sfilename;
            }

            public String getFnote() {
                return fnote;
            }

            public void setFnote(String fnote) {
                this.fnote = fnote;
            }

            public int getSjnum() {
                return sjnum;
            }

            public void setSjnum(int sjnum) {
                this.sjnum = sjnum;
            }

            public String getIsstatus() {
                return isstatus;
            }

            public void setIsstatus(String isstatus) {
                this.isstatus = isstatus;
            }

            public String getUnits() {
                return units;
            }

            public void setUnits(String units) {
                this.units = units;
            }

            public String getSonghuono() {
                return songhuono;
            }

            public void setSonghuono(String songhuono) {
                this.songhuono = songhuono;
            }

            public String getIscheck() {
                return ischeck;
            }

            public void setIscheck(String ischeck) {
                this.ischeck = ischeck;
            }

            public String getDjjlh() {
                return djjlh;
            }

            public void setDjjlh(String djjlh) {
                this.djjlh = djjlh;
            }

            public int getHxcnum() {
                return hxcnum;
            }

            public void setHxcnum(int hxcnum) {
                this.hxcnum = hxcnum;
            }

            public String getIsrk() {
                return isrk;
            }

            public void setIsrk(String isrk) {
                this.isrk = isrk;
            }

            public String getProviderfullname() {
                return providerfullname;
            }

            public void setProviderfullname(String providerfullname) {
                this.providerfullname = providerfullname;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getRknumber() {
                return rknumber;
            }

            public void setRknumber(int rknumber) {
                this.rknumber = rknumber;
            }

            public String getRespectarrivedate() {
                return respectarrivedate;
            }

            public void setRespectarrivedate(String respectarrivedate) {
                this.respectarrivedate = respectarrivedate;
            }

            public String getAutomemo() {
                return automemo;
            }

            public void setAutomemo(String automemo) {
                this.automemo = automemo;
            }

            public String getIsbianji() {
                return isbianji;
            }

            public void setIsbianji(String isbianji) {
                this.isbianji = isbianji;
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

            public String getSonghuoid() {
                return songhuoid;
            }

            public void setSonghuoid(String songhuoid) {
                this.songhuoid = songhuoid;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public int getCnum() {
                return cnum;
            }

            public void setCnum(int cnum) {
                this.cnum = cnum;
            }

            public int getSonghuonum() {
                return songhuonum;
            }

            public void setSonghuonum(int songhuonum) {
                this.songhuonum = songhuonum;
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

            public int getGoodnum() {
                return goodnum;
            }

            public void setGoodnum(int goodnum) {
                this.goodnum = goodnum;
            }
        }
    }
}
