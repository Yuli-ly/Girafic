package by.Girafic.controllers;

import by.Girafic.core.interactors.InteractorAccess;

public class GlobalValues
{
    public GlobalValues(InteractorAccess interactorAccess)
    {
        this.interactorAccess = interactorAccess;
    }

    public InteractorAccess interactorAccess;
}
