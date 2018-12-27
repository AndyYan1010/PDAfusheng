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
     * inspectionlist : [{"orderno":"PO2018100008","address":"闵行区莲花南路2129弄118号8座","providerfullname":"星域控制工程(上海)有限公司","inspectionlistentry":[{"snum":1,"num":1,"hxnum":0,"sfilename":"S3113040 R0.pdf","units":" 个","djjlh":"15326355","nrknum":1,"rknum":0,"price":1,"providerfullname":"星域控制工程(上海)有限公司","CadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","sggb":"1","id":"798C7013-03D9-4E72-9E32-F0FF04C76CE7","gb":"1","respectarrivedate":"2019-01-11 14:06:00","bhgnum":0,"automemo":"物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:","checknum":0,"isbianji":"1","cadlist":"S3113040 R0;","totalprice":0.86,"cadno":"S3113040","jlh":"15326329","version":"R0","issonghuo":"1","fixedbuyprice":0,"cgorderno":"PO2018100008","hegenum":0},{"snum":0,"num":1,"hxnum":1,"sfilename":"S3113040 R0.pdf","units":" 个","djjlh":"15326355","nrknum":0,"rknum":0,"price":1,"providerfullname":"星域控制工程(上海)有限公司","CadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","sggb":"1","id":"86F8A582-8A09-4F32-8E4F-9B572437F28A","gb":"1","respectarrivedate":"2018-12-28 12:43:00","bhgnum":0,"automemo":"物管库:4 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:8 个,请购:1 个,物料库180天内月均出库数:2.0 个。超过90天库存数量:物管库(3),","checknum":0,"isbianji":"0","cadlist":"S3113039 R0;","totalprice":0.86,"cadno":"S3113039","jlh":"15326327","version":"R0","issonghuo":"0","fixedbuyprice":0,"cgorderno":"PO2018100008","hegenum":0}],"jlh":15326355,"cgorderno":"OR18-12-12008","tel":"13764903331，33505868","id":"3200D091-02DB-47F8-A374-E732DF07BBEC","providerproxy":"熊建","fax":"021-33505738","lrsj":1538977995493}]
     * message : 列表查找成功
     */

    private int result;
    private String                   message;
    private List<InspectionlistBean> inspectionlist;

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

    public List<InspectionlistBean> getInspectionlist() {
        return inspectionlist;
    }

    public void setInspectionlist(List<InspectionlistBean> inspectionlist) {
        this.inspectionlist = inspectionlist;
    }

    public static class InspectionlistBean {
        /**
         * orderno : PO2018100008
         * address : 闵行区莲花南路2129弄118号8座
         * providerfullname : 星域控制工程(上海)有限公司
         * inspectionlistentry : [{"snum":1,"num":1,"hxnum":0,"sfilename":"S3113040 R0.pdf","units":" 个","djjlh":"15326355","nrknum":1,"rknum":0,"price":1,"providerfullname":"星域控制工程(上海)有限公司","CadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","sggb":"1","id":"798C7013-03D9-4E72-9E32-F0FF04C76CE7","gb":"1","respectarrivedate":"2019-01-11 14:06:00","bhgnum":0,"automemo":"物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:","checknum":0,"isbianji":"1","cadlist":"S3113040 R0;","totalprice":0.86,"cadno":"S3113040","jlh":"15326329","version":"R0","issonghuo":"1","fixedbuyprice":0,"cgorderno":"PO2018100008","hegenum":0},{"snum":0,"num":1,"hxnum":1,"sfilename":"S3113040 R0.pdf","units":" 个","djjlh":"15326355","nrknum":0,"rknum":0,"price":1,"providerfullname":"星域控制工程(上海)有限公司","CadLibjlh":"https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf","sggb":"1","id":"86F8A582-8A09-4F32-8E4F-9B572437F28A","gb":"1","respectarrivedate":"2018-12-28 12:43:00","bhgnum":0,"automemo":"物管库:4 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:8 个,请购:1 个,物料库180天内月均出库数:2.0 个。超过90天库存数量:物管库(3),","checknum":0,"isbianji":"0","cadlist":"S3113039 R0;","totalprice":0.86,"cadno":"S3113039","jlh":"15326327","version":"R0","issonghuo":"0","fixedbuyprice":0,"cgorderno":"PO2018100008","hegenum":0}]
         * jlh : 15326355
         * cgorderno : OR18-12-12008
         * tel : 13764903331，33505868
         * id : 3200D091-02DB-47F8-A374-E732DF07BBEC
         * providerproxy : 熊建
         * fax : 021-33505738
         * lrsj : 1538977995493
         */

        private String orderno;
        private String                        address;
        private String                        providerfullname;
        private int                           jlh;
        private String                        cgorderno;
        private String                        tel;
        private String                        id;
        private String                        providerproxy;
        private String                        fax;
        private long                          lrsj;
        private List<InspectionlistentryBean> inspectionlistentry;

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProviderfullname() {
            return providerfullname;
        }

        public void setProviderfullname(String providerfullname) {
            this.providerfullname = providerfullname;
        }

        public int getJlh() {
            return jlh;
        }

        public void setJlh(int jlh) {
            this.jlh = jlh;
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

        public String getProviderproxy() {
            return providerproxy;
        }

        public void setProviderproxy(String providerproxy) {
            this.providerproxy = providerproxy;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public long getLrsj() {
            return lrsj;
        }

        public void setLrsj(long lrsj) {
            this.lrsj = lrsj;
        }

        public List<InspectionlistentryBean> getInspectionlistentry() {
            return inspectionlistentry;
        }

        public void setInspectionlistentry(List<InspectionlistentryBean> inspectionlistentry) {
            this.inspectionlistentry = inspectionlistentry;
        }

        public static class InspectionlistentryBean {
            /**
             * snum : 1
             * num : 1
             * hxnum : 0
             * sfilename : S3113040 R0.pdf
             * units :  个
             * djjlh : 15326355
             * nrknum : 1
             * rknum : 0
             * price : 1
             * providerfullname : 星域控制工程(上海)有限公司
             * CadLibjlh : https://plant.fs-elliott.cn:3394//11732968//MP0612 R2.pdf
             * sggb : 1
             * id : 798C7013-03D9-4E72-9E32-F0FF04C76CE7
             * gb : 1
             * respectarrivedate : 2019-01-11 14:06:00
             * bhgnum : 0
             * automemo : 物管库:3 个,进料库:0 个,服务库:0 个,半成品库:0 个,转口贸易库:0 个,服务旧品库:0 个,旧品处理库:0 个,在途:7 个,请购:1 个,物料库180天内月均出库数:1.3 个。超过90天库存数量:
             * checknum : 0
             * isbianji : 1
             * cadlist : S3113040 R0;
             * totalprice : 0.86
             * cadno : S3113040
             * jlh : 15326329
             * version : R0
             * issonghuo : 1
             * fixedbuyprice : 0
             * cgorderno : PO2018100008
             * hegenum : 0
             */

            private int snum;
            private int    num;
            private int    hxnum;
            private String sfilename;
            private String units;
            private String djjlh;
            private int    nrknum;
            private int    rknum;
            private int    price;
            private String providerfullname;
            private String CadLibjlh;
            private String sggb;
            private String id;
            private String gb;
            private String respectarrivedate;
            private int    bhgnum;
            private String automemo;
            private int    checknum;
            private String isbianji;
            private String cadlist;
            private double totalprice;
            private String cadno;
            private String jlh;
            private String version;
            private String issonghuo;
            private int    fixedbuyprice;
            private String cgorderno;
            private int    hegenum;
            /**
             * sjsum : 0
             */

            private int    sjsum;
            /**
             * isMSelect : false
             */

            private boolean isMSelect;
            /**
             * mineMark : 256262
             */

            private String mineMark;

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getHxnum() {
                return hxnum;
            }

            public void setHxnum(int hxnum) {
                this.hxnum = hxnum;
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

            public String getDjjlh() {
                return djjlh;
            }

            public void setDjjlh(String djjlh) {
                this.djjlh = djjlh;
            }

            public int getNrknum() {
                return nrknum;
            }

            public void setNrknum(int nrknum) {
                this.nrknum = nrknum;
            }

            public int getRknum() {
                return rknum;
            }

            public void setRknum(int rknum) {
                this.rknum = rknum;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getProviderfullname() {
                return providerfullname;
            }

            public void setProviderfullname(String providerfullname) {
                this.providerfullname = providerfullname;
            }

            public String getCadLibjlh() {
                return CadLibjlh;
            }

            public void setCadLibjlh(String CadLibjlh) {
                this.CadLibjlh = CadLibjlh;
            }

            public String getSggb() {
                return sggb;
            }

            public void setSggb(String sggb) {
                this.sggb = sggb;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGb() {
                return gb;
            }

            public void setGb(String gb) {
                this.gb = gb;
            }

            public String getRespectarrivedate() {
                return respectarrivedate;
            }

            public void setRespectarrivedate(String respectarrivedate) {
                this.respectarrivedate = respectarrivedate;
            }

            public int getBhgnum() {
                return bhgnum;
            }

            public void setBhgnum(int bhgnum) {
                this.bhgnum = bhgnum;
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

            public double getTotalprice() {
                return totalprice;
            }

            public void setTotalprice(double totalprice) {
                this.totalprice = totalprice;
            }

            public String getCadno() {
                return cadno;
            }

            public void setCadno(String cadno) {
                this.cadno = cadno;
            }

            public String getJlh() {
                return jlh;
            }

            public void setJlh(String jlh) {
                this.jlh = jlh;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getIssonghuo() {
                return issonghuo;
            }

            public void setIssonghuo(String issonghuo) {
                this.issonghuo = issonghuo;
            }

            public int getFixedbuyprice() {
                return fixedbuyprice;
            }

            public void setFixedbuyprice(int fixedbuyprice) {
                this.fixedbuyprice = fixedbuyprice;
            }

            public String getCgorderno() {
                return cgorderno;
            }

            public void setCgorderno(String cgorderno) {
                this.cgorderno = cgorderno;
            }

            public int getHegenum() {
                return hegenum;
            }

            public void setHegenum(int hegenum) {
                this.hegenum = hegenum;
            }

            public int getSjsum() {
                return sjsum;
            }

            public void setSjsum(int sjsum) {
                this.sjsum = sjsum;
            }

            public boolean isIsMSelect() {
                return isMSelect;
            }

            public void setIsMSelect(boolean isMSelect) {
                this.isMSelect = isMSelect;
            }

            public String getMineMark() {
                return mineMark;
            }

            public void setMineMark(String mineMark) {
                this.mineMark = mineMark;
            }
        }
    }
}
