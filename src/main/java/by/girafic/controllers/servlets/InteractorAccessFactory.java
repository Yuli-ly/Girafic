package by.girafic.controllers.servlets;

import by.girafic.core.interactors.InteractorAccess;
import by.girafic.database.InMemoryDataBase;

public class InteractorAccessFactory
{
    public static InteractorAccess getInteractorAccess()
    {
        return InteractorAccess.getInstance(InMemoryDataBase.getInstance(),InMemoryDataBase.getInstance());
    }
}
