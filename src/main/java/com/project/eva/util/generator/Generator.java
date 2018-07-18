package com.project.eva.util.generator;

/**
 * The interface describes a set of methods for generating Object.
 *
 * @param <T> extends Object.

 */
public interface Generator<T> {

    /**
     * Generates object.
     *
     * @return The generated object.
     */
    T generate();
}
