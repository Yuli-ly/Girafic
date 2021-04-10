package by.Girafic.core.view;

public class ViewData<T>
{
    public ViewData(T field, boolean changeability)
    {
        this.field = field;
        this.changeability = changeability;
    }

    @Override
    public String toString()
    {
        return "ViewData{" +
                "field=" + field +
                '}';
    }

    public T field;
    public boolean changeability;
}
