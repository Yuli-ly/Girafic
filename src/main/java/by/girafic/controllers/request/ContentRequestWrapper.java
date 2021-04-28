package by.girafic.controllers.request;

import by.girafic.core.contentdata.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public class ContentRequestWrapper extends RequestWrapper
{
    public ContentRequestWrapper(HttpServletRequest request,
                                 HttpServletResponse response,
                                 LoginSetter setter,
                                 LoginGetter getter)
    {
        super(request,response ,setter, getter);
    }
    public ContentType takeContentType()
    {
        return switch (request.getParameter("Type"))
                {
                    case "material"-> ContentType.Material;
                    case "section" -> ContentType.Section;
                    case "course" -> ContentType.Course;
                    default -> throw new IllegalArgumentException("No content user type");
                };
    }

    private ContentModifyData takeContent()
    {
        return new ContentModifyData(
                request.getParameter("Title"),
                request.getParameter("Description"),
                takeContentType());
    }
    public MaterialModifyData takeMaterial()
    {
        return new MaterialModifyData(takeContent(),
                request.getParameter("Filling"));
    }
    public SectionModifyData takeSection()
    {
        int[] id = Arrays.stream(request.getParameterValues("Content"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new SectionModifyData(takeContent(),id);
    }
    public CourseModifyData takeCourse()
    {
        return null;
    }
}
