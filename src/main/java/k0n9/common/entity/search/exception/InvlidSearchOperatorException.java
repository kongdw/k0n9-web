package k0n9.common.entity.search.exception;

import k0n9.common.entity.search.SearchOperator;

public final class InvlidSearchOperatorException extends SearchException {

    private static final long serialVersionUID = -3578752270279557366L;

    public InvlidSearchOperatorException(String searchProperty, String operatorStr) {
        this(searchProperty, operatorStr, null);
    }

    public InvlidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
    }
}
