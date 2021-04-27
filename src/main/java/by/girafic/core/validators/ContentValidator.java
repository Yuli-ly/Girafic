package by.girafic.core.validators;

public class ContentValidator
{
    private static final CheckResult success = new CheckResult(true,"Успешно");
    public CheckResult checkTitle(String title)
    {
        return success;
    }
    public CheckResult checkDescription()
    {
        return success;
    }
    public CheckResult checkFilling(String filling)
    {
        return success;
    }
}
