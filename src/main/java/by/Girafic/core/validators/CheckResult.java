package by.Girafic.core.validators;

public class CheckResult
{
    public CheckResult(boolean status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public boolean status;
    public String message;
}
