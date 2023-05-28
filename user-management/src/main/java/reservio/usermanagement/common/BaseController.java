package reservio.usermanagement.common;

public interface BaseController <T>{
    public T create(T body);
    public T update(T body);
}
