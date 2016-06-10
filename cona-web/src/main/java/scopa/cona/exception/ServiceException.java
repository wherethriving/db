package scopa.cona.exception;

import scopa.cona.constant.Constant;

import java.io.Serializable;

/**
 * Created by panda on 5/20/16.
 */
public class ServiceException extends ConaException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super("SERVICE" + Constant.exception);
    }

    public ServiceException(String msg) {
        super(msg);
    }


    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ServiceException(Throwable cause, String section, String errorId) {
        super(cause, section, errorId);
    }

    public ServiceException(String section, String errorId, String msg) {
        super(section, errorId, msg);
    }

    public static ServiceException ENTITY_IS_NOT_FOUND(String inputName) {
        return new ServiceException("SERVICE", "ENTITY_IS_NOT_FOUND", inputName);
    }

    public static ServiceException NO_INPUT(String input) {
        return new ServiceException("SERVICE", "NO_INPUT", input);
    }

}
