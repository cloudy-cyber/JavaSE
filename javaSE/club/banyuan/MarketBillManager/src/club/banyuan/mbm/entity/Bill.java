package club.banyuan.mbm.entity;

public class Bill {
    private int id;//账单id
    private int isPay;//是否付款，1表示已付款，0表示位付款
    private String isPayStr;//是否付款
    private float money;//账单金额
    private String product;//商品描述
    private int providerId;//供应商id
    private String providerName;//供应商名字
    private String updateTime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public String getIsPayStr() {
        return isPayStr;
    }

    public void setIsPayStr(String isPayStr) {
        this.isPayStr = isPayStr;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
