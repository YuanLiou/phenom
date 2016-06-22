package liou.rayyuan.phenom.model.repository;

import java.util.ArrayList;
import java.util.List;

import liou.rayyuan.phenom.model.domain.Plurk;

/**
 * Created by louis383 on 2016/6/11.
 */

public class PlurkDataProvider {
    private List<Plurk> items;

    public PlurkDataProvider() {
        this(null);
    }

    public PlurkDataProvider(List<Plurk> items) {
        if (items == null) {
            items = new ArrayList<>();
        }

        setupItems(items);
    }

    public void setupItems(List<Plurk> items) {
        this.items = items;
    }

    public void addItems(List<Plurk> items) {
        this.items.addAll(items);
    }

    public void updateItem(Plurk plurk, int position) {
        this.items.set(position, plurk);
    }

    public int getCount() {
        return this.items.size();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public Plurk getItem(int position) {
        return items.get(position);
    }
}
