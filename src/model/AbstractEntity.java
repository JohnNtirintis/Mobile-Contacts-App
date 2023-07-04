package model;

/**
 * AbstractEntity is an abstract class that implements the IdentifiableEntity interface.
 * It represents an entity with a unique identifier (ID) and provides a common base for all entities in the system.
 * @author Ntirintis John
 */
public abstract class AbstractEntity implements IdentifiableEntity{

    private long id;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
