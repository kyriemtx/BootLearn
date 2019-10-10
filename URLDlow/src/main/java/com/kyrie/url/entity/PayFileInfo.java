package com.kyrie.url.entity;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @ClassName PayFileInfo
 * @Description  消费对账文件实体类
 * @Author Kyrie
 * @Date 2019/9/10 16:27
 * @Version 1.0
 **/
public class PayFileInfo {

    static final String TRIM = "\\s*(\\S+)\\s*";
    //商户在平台唯一ID
    @CsvBindByPosition(position=0)
    private String AppID;
    //子商户编号
    @CsvBindByPosition(position=1)
    private String SubCompanyID;
    //子商户商户名
    @CsvBindByPosition(position=2)
    private String SubCompanyname;
    //银联商户编号
    @CsvBindByPosition(position=3)
    private String Merchantid;
    //交易终端
    @CsvBindByPosition(position=4)
    private String Terminalnumber;
    //终端交易流水号
    @CsvBindByPosition(position=5)
    private String Terminaldealid;
    //交易流水号
    @CsvBindByPosition(position=6)
    private String Unionpaydealid;
    //订单号
    @CsvBindByPosition(position=7)
    private String Ordernumber;
    //实际刷卡金额
    @CsvBindByPosition(position=8)
    private String Totalpayment;
    //计算T1手续费
    @CsvBindByPosition(position=9)
    private String T1Settlementfee;
    //计算D0手续费
    @CsvBindByPosition(position=10)
    private String T0Settlementfee;
    //实际到账金额
    @CsvBindByPosition(position=11)
    private String Companyreceived;
    //支付方式
    @CsvBindByPosition(position=12)
    private String Paymenttype;
    //结算方式
    @CsvBindByPosition(position=13)
    private String Settlementtype;
    //划账方式
    @CsvBindByPosition(position=14)
    private String Transfertype;

    @CsvBindByPosition(position =15)
    private String Bankaccount;
    //支付卡类型
    @CsvBindByPosition(position=16)
    private String Bankcardtype;
    //交易日期
    @CsvBindByPosition(position=17)
    private String Businesstime;
    //日结日期
    @CsvBindByPosition(position=18)
    private String Settlementtime;

    //返回支付卡号密文
    //@CsvBindByPosition(position=19,capture=TRIM)
    private String Bankaccountenc;
    //返回支付卡号掩码
    //@CsvBindByPosition(position=15,capture=TRIM)
    private String Bankaccountmask;
    //对账日期
    private String Reconciliationdate;



    public String getAppID() {
        return AppID;
    }
    public void setAppID(String appID) {
        AppID = appID;
    }
    public String getSubCompanyID() {
        return SubCompanyID;
    }
    public void setSubCompanyID(String subCompanyID) {
        SubCompanyID = subCompanyID;
    }
    public String getSubCompanyname() {
        return SubCompanyname;
    }
    public void setSubCompanyname(String subCompanyname) {
        SubCompanyname = subCompanyname;
    }
    public String getMerchantid() {
        return Merchantid;
    }
    public void setMerchantid(String merchantid) {
        Merchantid = merchantid;
    }
    public String getTerminalnumber() {
        return Terminalnumber;
    }
    public void setTerminalnumber(String terminalnumber) {
        Terminalnumber = terminalnumber;
    }
    public String getTerminaldealid() {
        return Terminaldealid;
    }
    public void setTerminaldealid(String terminaldealid) {
        Terminaldealid = terminaldealid;
    }
    public String getUnionpaydealid() {
        return Unionpaydealid;
    }
    public void setUnionpaydealid(String unionpaydealid) {
        Unionpaydealid = unionpaydealid;
    }
    public String getOrdernumber() {
        return Ordernumber;
    }
    public void setOrdernumber(String ordernumber) {
        Ordernumber = ordernumber;
    }
    public String getTotalpayment() {
        return Totalpayment;
    }
    public void setTotalpayment(String totalpayment) {
        Totalpayment = totalpayment;
    }
    public String getT1Settlementfee() {
        return T1Settlementfee;
    }
    public void setT1Settlementfee(String t1Settlementfee) {
        T1Settlementfee = t1Settlementfee;
    }
    public String getT0Settlementfee() {
        return T0Settlementfee;
    }
    public void setT0Settlementfee(String t0Settlementfee) {
        T0Settlementfee = t0Settlementfee;
    }
    public String getCompanyreceived() {
        return Companyreceived;
    }
    public void setCompanyreceived(String companyreceived) {
        Companyreceived = companyreceived;
    }
    public String getPaymenttype() {
        return Paymenttype;
    }
    public void setPaymenttype(String paymenttype) {
        Paymenttype = paymenttype;
    }
    public String getSettlementtype() {
        return Settlementtype;
    }
    public void setSettlementtype(String settlementtype) {
        Settlementtype = settlementtype;
    }
    public String getTransfertype() {
        return Transfertype;
    }
    public void setTransfertype(String transfertype) {
        Transfertype = transfertype;
    }

    public String getBankcardtype() {
        return Bankcardtype;
    }
    public void setBankcardtype(String bankcardtype) {
        Bankcardtype = bankcardtype;
    }
    public String getBusinesstime() {
        return Businesstime;
    }
    public void setBusinesstime(String businesstime) {
        Businesstime = businesstime;
    }
    public String getSettlementtime() {
        return Settlementtime;
    }
    public void setSettlementtime(String settlementtime) {
        Settlementtime = settlementtime;
    }

    public String getBankaccountmask() {
        return Bankaccountmask;
    }

    public void setBankaccountmask(String bankaccountmask) {
        Bankaccountmask = bankaccountmask;
    }

    public String getBankaccountenc() {
        return Bankaccountenc;
    }

    public void setBankaccountenc(String bankaccountenc) {
        Bankaccountenc = bankaccountenc;
    }

    public String getBankaccount() {
        return Bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        Bankaccount = bankaccount;
    }

    public String getReconciliationdate() {
        return Reconciliationdate;
    }

    public void setReconciliationdate(String reconciliationdate) {
        Reconciliationdate = reconciliationdate;
    }

    @Override
    public String toString() {
        return "PayFileInfo{" +
                "AppID='" + AppID + '\'' +
                ", SubCompanyID='" + SubCompanyID + '\'' +
                ", SubCompanyname='" + SubCompanyname + '\'' +
                ", Merchantid='" + Merchantid + '\'' +
                ", Terminalnumber='" + Terminalnumber + '\'' +
                ", Terminaldealid='" + Terminaldealid + '\'' +
                ", Unionpaydealid='" + Unionpaydealid + '\'' +
                ", Ordernumber='" + Ordernumber + '\'' +
                ", Totalpayment='" + Totalpayment + '\'' +
                ", T1Settlementfee='" + T1Settlementfee + '\'' +
                ", T0Settlementfee='" + T0Settlementfee + '\'' +
                ", Companyreceived='" + Companyreceived + '\'' +
                ", Paymenttype='" + Paymenttype + '\'' +
                ", Settlementtype='" + Settlementtype + '\'' +
                ", Transfertype='" + Transfertype + '\'' +
                ", Bankaccount='" + Bankaccount + '\'' +
                ", Bankcardtype='" + Bankcardtype + '\'' +
                ", Businesstime='" + Businesstime + '\'' +
                ", Settlementtime='" + Settlementtime + '\'' +
                ", Bankaccountenc='" + Bankaccountenc + '\'' +
                ", Bankaccountmask='" + Bankaccountmask + '\'' +
                ", Reconciliationdate='" + Reconciliationdate + '\'' +
                '}';
    }
}
