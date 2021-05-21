<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="LinkMaker" type="by.girafic.controllers.request.RequestWrapper.LinkMaker"--%>
<%--@elvariable id="path" type="java.lang.String"--%>

<div class="wrapper">
  <div class="top_navbar">
    <div class="menu">
      <div class="logo">
        РФИКТ
      </div>
    </div>
    <div class="exit">
      <ul>
        <li>
          <a href="${LinkMaker.home()}">
            <span class="icon"><i class="fab fa-delicious"></i></span><span class="title">Домой</span>
          </a>
        </li>
        <li>
          <a href="${LinkMaker.exit()}">
            <span class="icon"><i class="fab fa-delicious"></i></span>
            <span class="title">Выход</span>
</a>
</li>
</ul>
  </div>
  </div>

  </div>
</div>