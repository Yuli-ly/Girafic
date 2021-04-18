package by.Girafic;

import by.Girafic.core.interactors.InteractorAccess;
import by.Girafic.database.InMemoryDataBase;

public class GlobalValuesAccess
{
    static GlobalValues globalValues;
    static public GlobalValues getValues()
    {
        if(globalValues==null)
            init();
        return globalValues;
    }
    static private void init()
    {
        InMemoryDataBase db = new InMemoryDataBase();
        globalValues = new GlobalValues(new InteractorAccess(db,db));
    }
}
