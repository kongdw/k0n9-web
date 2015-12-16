package k0n9.common.entity.search.exception;

public final class InvalidSearchPropertyException extends SearchException {

    private static final long serialVersionUID = -3763162614463825567L;

    public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }


}
