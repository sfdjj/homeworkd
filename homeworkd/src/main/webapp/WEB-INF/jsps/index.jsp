<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/20 0020
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<link href="/resources/css/index.css" rel="stylesheet" type="text/css" />
<script src="/resources/js/index.js"></script>
<script src="/resources/js/text.js"></script>

<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
          <div class="header">
              <form action="/counter/getUrl">
                  <input type="text" name="url" value="输入文章链接" id="text" onclick="clickTest()" />
                  <input type="submit" name="" value="添加" id="submit">
              </form>
          </div>
          <div class="main">
              <table id="content" cellspacing="0">
                  <tr class=\"content-title\">
                      <th class=\"tableHead-title\">标题</th>
                      <th class=\"tableHead-number\">字数</th>
                      <th class=\"tableHead-cnNumber\">中文字数</th>
                      <th class=\"tableHead-enNumber\">英文字数</th>
                      <th class=\"tableHead-puncNumber\">标点符号数</th>
                  </tr>
              </table>
          </div>
        <script src="/resources/js/page.js" type="text/javascript" ></script>
        <div class="pageIndex">
            <input type="button" class="page-button" id="last-page" value="<" onclick="lastPage()" />
            <%
                if(request.getAttribute("count")!=null) {
                    int c = (int)request.getAttribute("count");
                    int p = c/8;
                    if(p*8!=c) {
                        p++;
                    }
                    for(int i=1;i<=p;i++) {
            %>
            <input type="button" class="page-button" background-color="blue" value="<%=i%>" id="page<%=i%>" onclick="getDataByPage(<%=i%>)"/>
            <%
                    }
            %>
            <input type="button" class="page-button" id="next-page" value=">" onclick="nextPage(<%=p%>)" />
            <%
                }
            %>

        </div>
        <p hidden id="nowPage" value=1></p>
    </div>
</body>
</html>
