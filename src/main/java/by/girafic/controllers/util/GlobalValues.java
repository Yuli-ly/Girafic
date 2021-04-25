package by.girafic.controllers.util;

import by.girafic.core.interactors.InteractorAccess;

public class GlobalValues
{
    public GlobalValues(InteractorAccess interactorAccess)
    {
        this.interactorAccess = interactorAccess;
    }

    public InteractorAccess interactorAccess;
}
