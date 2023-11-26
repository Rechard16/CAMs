package entity.model.change;

import entity.exception.IllegalModificationException;
import entity.model.CampInfo;

/**
 * The Change interface is used to represent a change to be made to a camp.
 * It is used in the CampInfoModifier class.
 */
public interface Change {

    /**
     * Modifies the camp information.
     * 
     * @param campInfo The camp information to be modified.
     * @throws IllegalModificationException 
     */
    public void modify(CampInfo campInfo) throws IllegalModificationException;

    /**
     * Returns the description of the change.
     * 
     * @return The description of the change.
     */
    public String getDescription();
}
