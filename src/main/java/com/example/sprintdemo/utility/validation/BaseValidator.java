package com.example.sprintdemo.utility.validation;

/**
 * @param <T>
 *     Class of the object that we want to validate.
 */
public interface BaseValidator<T> {
	 void validate(T obj);
}
