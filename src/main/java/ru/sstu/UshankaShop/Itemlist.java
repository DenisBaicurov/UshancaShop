package ru.sstu.UshankaShop;

import java.util.List;

public class Itemlist {
    private List<Item> items;
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Itemlist() {
    }

    public Itemlist(List<Item> items) {
        this.items = items;
    }


}
