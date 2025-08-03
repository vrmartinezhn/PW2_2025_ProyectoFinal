package pw2.gestionacademica.pw2_2025_proyectofinal.model;

import java.util.List;

public class MateriasResponse {
    private List<Materia> items;
    private boolean hasMore;
    private int limit;
    private int count;

    public List<Materia> getItems() {
        return items;
    }

    public void setItems(List<Materia> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
