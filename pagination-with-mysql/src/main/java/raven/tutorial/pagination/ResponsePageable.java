package raven.tutorial.pagination;

public class ResponsePageable<P> extends Pageable {

    public P getData() {
        return data;
    }

    public ResponsePageable(int total, int page, int pageSize, int limit, P data) {
        super(total, page, pageSize, limit);
        this.data = data;
    }

    private final P data;
}