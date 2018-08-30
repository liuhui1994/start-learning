package org.business.system.order.em;

public enum OrderStatusType {
    UNSEND("待发货"),
    SENDED("已发货"),
    RECEIVED("确认收货");

    private String text;

    OrderStatusType(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
