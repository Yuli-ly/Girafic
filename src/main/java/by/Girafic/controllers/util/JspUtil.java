package by.Girafic.controllers.util;

import by.Girafic.core.contentdata.ContentLinkData;

public class JspUtil
{
    public static String createLinkToContent(String path, String login, String password, ContentLinkData data)
    {
        return "<a href=\"" +
                path +
                "/content" +
                "?" +
                "login=" + login +
                "&password=" + password +
                "&id=" + data.id +
                "\">" + data.name + "</a>";
    }
}
