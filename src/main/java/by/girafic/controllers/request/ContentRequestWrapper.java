package by.girafic.controllers.request;

import by.girafic.core.contentdata.modification.ContentModifyData;
import by.girafic.core.contentdata.ContentType;
import by.girafic.core.contentdata.modification.CourseModifyData;
import by.girafic.core.contentdata.modification.MaterialModifyData;
import by.girafic.core.contentdata.modification.SectionModifyData;
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
        return new SectionModifyData(takeContent(),
                Arrays.stream(request.getParameterValues("Content"))
                .mapToInt(Integer::parseInt)
                .toArray());
    }
    public CourseModifyData takeCourse()
    {
        return new CourseModifyData(takeContent(),
                Arrays.stream(request.getParameterValues("Sections"))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                Arrays.stream(request.getParameterValues("Users"))
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );
    }
}
