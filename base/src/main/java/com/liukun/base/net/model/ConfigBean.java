package com.liukun.base.net.model;

import java.util.List;

/**
 * Author: liukun on 2020/6/15.
 * Mail  : 3266817262@qq.com
 * Description: 项目基本配置信息的实体类
 */
public class ConfigBean {


    /**
     * domain : www.jianyunkeji.cn
     * test_baseUrl : test.jianyunkeji.net
     * on_baseUrl : h5.jianyunkeji.cn
     * cdn_domain : cdn.jianyunkeji.net
     * on_cdn : cdn.jianyunkeji.cn
     * platform_name : 粒粒禾谷
     * platform_logo : config/lili/logo.png
     * platform_mer_logo : config/lili/merlogo.png
     * logo : config/depu/logo.png
     * service_phone : 0371-7889032
     * withdraw :
     * service_date : false
     * company_address : 河南省郑州市惠济区迎宾路街道开元路98号1号楼7层723号
     * website :
     * start_image :
     * company_name : 军人就业网
     * public_wechat : 粒粒禾谷
     * public_wechat_url : config/lili/logo.png
     * copyright : ©2020 军人就业网.All rights reserved
     * share_title : 军人就业网分享
     * share_subtitle : 军人就业网
     * develop_company : true
     * develop_tel : 400-8086-828
     * develop_name : 本系统由简云科技提供技术支持
     * develop_website : http://www.jianyunkeji.cn
     * referrer_phone : 16603987573
     * bank_list : [{"trans_type":"0","name":"张磊","unit":"张磊","bank_type":"中国平安银行","number":" xxxx xxxx xxxx xxxx xxx"},{"trans_type":"1","name":"支付宝收款","unit":"张磊","bank_type":"支付宝","number":"xxxxxxxxx"}]
     * notice : [{"id":"1","conntent":"转账之后，请妥善保存好凭证，并在此提交转账凭证"},{"id":"2","conntent":"如遇到限额导致无法转账成功，请选择银行转账或联系客服：xxxxxxxx"},{"id":"3","conntent":"支付宝，务必添加备注（真实姓名和会员账号）如 李四15600001234"}]
     * type : 2
     * public_wechant :
     * qrcode_wechat : /soldieradmin/images/20200612/2020061216182497867_1591949904.png
     */

    private String domain;
    private String test_baseUrl;
    private String on_baseUrl;
    private String cdn_domain;
    private String on_cdn;
    private String platform_name;
    private String platform_logo;
    private String platform_mer_logo;
    private String logo;
    private String service_phone;
    private String withdraw;
    private boolean service_date;
    private String company_address;
    private String website;
    private String start_image;
    private String company_name;
    private String public_wechat;
    private String public_wechat_url;
    private String copyright;
    private String share_title;
    private String share_subtitle;
    private boolean develop_company;
    private String develop_tel;
    private String develop_name;
    private String develop_website;
    private String referrer_phone;
    private String type;
    private String public_wechant;
    private String qrcode_wechat;
    private List<BankListEntity> bank_list;
    private List<NoticeEntity> notice;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTest_baseUrl() {
        return test_baseUrl;
    }

    public void setTest_baseUrl(String test_baseUrl) {
        this.test_baseUrl = test_baseUrl;
    }

    public String getOn_baseUrl() {
        return on_baseUrl;
    }

    public void setOn_baseUrl(String on_baseUrl) {
        this.on_baseUrl = on_baseUrl;
    }

    public String getCdn_domain() {
        return cdn_domain;
    }

    public void setCdn_domain(String cdn_domain) {
        this.cdn_domain = cdn_domain;
    }

    public String getOn_cdn() {
        return on_cdn;
    }

    public void setOn_cdn(String on_cdn) {
        this.on_cdn = on_cdn;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String platform_name) {
        this.platform_name = platform_name;
    }

    public String getPlatform_logo() {
        return platform_logo;
    }

    public void setPlatform_logo(String platform_logo) {
        this.platform_logo = platform_logo;
    }

    public String getPlatform_mer_logo() {
        return platform_mer_logo;
    }

    public void setPlatform_mer_logo(String platform_mer_logo) {
        this.platform_mer_logo = platform_mer_logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public boolean isService_date() {
        return service_date;
    }

    public void setService_date(boolean service_date) {
        this.service_date = service_date;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStart_image() {
        return start_image;
    }

    public void setStart_image(String start_image) {
        this.start_image = start_image;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPublic_wechat() {
        return public_wechat;
    }

    public void setPublic_wechat(String public_wechat) {
        this.public_wechat = public_wechat;
    }

    public String getPublic_wechat_url() {
        return public_wechat_url;
    }

    public void setPublic_wechat_url(String public_wechat_url) {
        this.public_wechat_url = public_wechat_url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public String getShare_subtitle() {
        return share_subtitle;
    }

    public void setShare_subtitle(String share_subtitle) {
        this.share_subtitle = share_subtitle;
    }

    public boolean isDevelop_company() {
        return develop_company;
    }

    public void setDevelop_company(boolean develop_company) {
        this.develop_company = develop_company;
    }

    public String getDevelop_tel() {
        return develop_tel;
    }

    public void setDevelop_tel(String develop_tel) {
        this.develop_tel = develop_tel;
    }

    public String getDevelop_name() {
        return develop_name;
    }

    public void setDevelop_name(String develop_name) {
        this.develop_name = develop_name;
    }

    public String getDevelop_website() {
        return develop_website;
    }

    public void setDevelop_website(String develop_website) {
        this.develop_website = develop_website;
    }

    public String getReferrer_phone() {
        return referrer_phone;
    }

    public void setReferrer_phone(String referrer_phone) {
        this.referrer_phone = referrer_phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublic_wechant() {
        return public_wechant;
    }

    public void setPublic_wechant(String public_wechant) {
        this.public_wechant = public_wechant;
    }

    public String getQrcode_wechat() {
        return qrcode_wechat;
    }

    public void setQrcode_wechat(String qrcode_wechat) {
        this.qrcode_wechat = qrcode_wechat;
    }

    public List<BankListEntity> getBank_list() {
        return bank_list;
    }

    public void setBank_list(List<BankListEntity> bank_list) {
        this.bank_list = bank_list;
    }

    public List<NoticeEntity> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeEntity> notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "domain='" + domain + '\'' +
                ", test_baseUrl='" + test_baseUrl + '\'' +
                ", on_baseUrl='" + on_baseUrl + '\'' +
                ", cdn_domain='" + cdn_domain + '\'' +
                ", on_cdn='" + on_cdn + '\'' +
                ", platform_name='" + platform_name + '\'' +
                ", platform_logo='" + platform_logo + '\'' +
                ", platform_mer_logo='" + platform_mer_logo + '\'' +
                ", logo='" + logo + '\'' +
                ", service_phone='" + service_phone + '\'' +
                ", withdraw='" + withdraw + '\'' +
                ", service_date=" + service_date +
                ", company_address='" + company_address + '\'' +
                ", website='" + website + '\'' +
                ", start_image='" + start_image + '\'' +
                ", company_name='" + company_name + '\'' +
                ", public_wechat='" + public_wechat + '\'' +
                ", public_wechat_url='" + public_wechat_url + '\'' +
                ", copyright='" + copyright + '\'' +
                ", share_title='" + share_title + '\'' +
                ", share_subtitle='" + share_subtitle + '\'' +
                ", develop_company=" + develop_company +
                ", develop_tel='" + develop_tel + '\'' +
                ", develop_name='" + develop_name + '\'' +
                ", develop_website='" + develop_website + '\'' +
                ", referrer_phone='" + referrer_phone + '\'' +
                ", type='" + type + '\'' +
                ", public_wechant='" + public_wechant + '\'' +
                ", qrcode_wechat='" + qrcode_wechat + '\'' +
                ", bank_list=" + bank_list +
                ", notice=" + notice +
                '}';
    }

    public static class BankListEntity {
        /**
         * trans_type : 0
         * name : 张磊
         * unit : 张磊
         * bank_type : 中国平安银行
         * number :  xxxx xxxx xxxx xxxx xxx
         */

        private String trans_type;
        private String name;
        private String unit;
        private String bank_type;
        private String number;

        public String getTrans_type() {
            return trans_type;
        }

        public void setTrans_type(String trans_type) {
            this.trans_type = trans_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getBank_type() {
            return bank_type;
        }

        public void setBank_type(String bank_type) {
            this.bank_type = bank_type;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static class NoticeEntity {
        /**
         * id : 1
         * conntent : 转账之后，请妥善保存好凭证，并在此提交转账凭证
         */

        private String id;
        private String conntent;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getConntent() {
            return conntent;
        }

        public void setConntent(String conntent) {
            this.conntent = conntent;
        }
    }

}
