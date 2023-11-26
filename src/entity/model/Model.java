package entity.model;

import java.io.Serializable;

/**
 * The Model class is an abstract representation of an entity in the
 * Camp Manager Sytem.
 * It is designed to be extensible and provides a common framework for all
 * entities
 * in the application. The class implements the Serializable interface, allowing
 * objects of its subclasses to be serialized for storage or transmission.
 */

public abstract class Model implements Serializable {

    /**
     * This abstract method getId() is intended to be implemented by subclasses.
     * It should return the unique identifier of the entity. The type of the ID is
     * integer, indicating that all subclasses should provide a numeric ID.
     *
     * @return int representing the unique ID of the model.
     */

    public abstract int getID();
}
