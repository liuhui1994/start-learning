package org.business.system.order.em;

public enum PayStatus {

    payed("已付款"),
    unpay("代付款");

    PayStatus(String text){
        this.text =text;
    }
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
