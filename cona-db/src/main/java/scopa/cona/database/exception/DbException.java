package scopa.cona.database.exception;

import scopa.cona.constant.Constant;
import scopa.cona.exception.ConaException;

/**
 * Created by panda on 5/20/16.
 */
public class DbException extends ConaException {
    private static final long serialVersionUID = 1L;

    public DbException() {
        super("DB" + Constant.exception);
    }

    public DbException(String msg) {
        super(msg);
    }

    public DbException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DbException(Throwable cause) {
        super("DB" + Constant.exception, cause);
    }

    public DbException(Throwable cause, String section, String errorId) {
        super(cause, section, errorId);
    }

    public DbException(String section, String errorId, String msg) {
        super(section, errorId, msg);
    }

    public DbException(Throwable cause, String section, String errorId, String msg) {
        super(cause, section, errorId, msg);
    }

    public static DbException ENTITY_IS_NOT_FOUND(String entityName) {
        return new DbException("DB", "ENTITY_IS_NOT_FOUND", entityName);
    }

    public static DbException ENTITY_IS_NOT_FOUND(Throwable cause, String entityName) {
        return new DbException(cause, "DB", "ENTITY_IS_NOT_FOUND", entityName);
    }

}
