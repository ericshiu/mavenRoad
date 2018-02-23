package com.torch.model;

public class Order {
    private Integer id;

    private String name;

    private Integer amt;

    private Integer quantity;

    public Order(Integer id, String name, Integer amt, Integer quantity) {
        this.id = id;
        this.name = name;
        this.amt = amt;
        this.quantity = quantity;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}