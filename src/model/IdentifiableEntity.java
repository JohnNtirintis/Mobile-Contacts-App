package model;

/**
 * IdentifiableEntity is a functional interface that represents an entity with an identifier (ID).
 * It has one method, getId(), which returns the ID of the entity.
 * @author Ntirintis John
 */
@FunctionalInterface
public interface IdentifiableEntity {

    /**
     *
     * Returns the id of the entity
     *
     * @return
     */
    long getId();
}
