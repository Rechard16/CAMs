package model.change;

import model.CampInfo;

public interface Change {
    public void modify(CampInfo campInfo);
    public String getDescription();
}
