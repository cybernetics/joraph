package com.joraph.schema;

import java.beans.PropertyDescriptor;

import com.joraph.JoraphException;

public abstract class AbstractProperty<T>
	implements Property<T> {

	private PropertyDescriptor descriptor;

	/**
	 * @param descriptor the descriptor to set
	 */
	protected void setDescriptor(PropertyDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public String getName() {
		return descriptor.getName();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T read(Object obj) {
		try {
			return (T)descriptor.getReadMethod().invoke(obj);
		} catch (Exception e) {
			throw new JoraphException(e);
		}
	}

	@Override
	public void write(Object obj, Object value) {
		try {
			descriptor.getWriteMethod().invoke(obj, value);
		} catch (Exception e) {
			throw new JoraphException(e);
		}
	}

}