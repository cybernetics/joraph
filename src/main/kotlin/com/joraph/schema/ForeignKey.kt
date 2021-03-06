package com.joraph.schema

/**
 * Represents a foreign key from one entity to another.  Foreign keys always
 * reference the foreign entity's primary key.
 */
open class ForeignKey<T, R>(
        val entityClass: Class<T>,
        val foreignEntity: Class<*>,
        accessor: (T) -> R?) : BaseProperty<T, R>(accessor), Property<T, R> {

    override fun toString(): String {
        return (entityClass.name
                + "." + propertyAccessor + "->"
                + foreignEntity.name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as ForeignKey<*, *>

        if (entityClass != other.entityClass) return false
        if (foreignEntity != other.foreignEntity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + entityClass.hashCode()
        result = 31 * result + foreignEntity.hashCode()
        return result
    }


}

