package by.girafic.core.validators;

public class CheckResult
{
    public CheckResult(boolean status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public final boolean status;
    public final String message;
}
