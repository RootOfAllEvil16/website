package com.project.eva.exception;

public class DuplicateException extends RuntimeException {
    /**
     * Конструктр без параметров.
     */
    public DuplicateException() {
        super();
    }

    /**
     * Конструкто с параметром.
     *
     * @param message Сообщение исключения.
     */
    public DuplicateException(final String message) {
        super(message);
    }

    public DuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(final Throwable cause) {
        super(cause);
    }
}

