<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/12/12
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post("getMenu",function (data) {
                var result = "";
                for (var i=0;i<data.length;i++){
                    result+="<dl>";
                    result+="<dt>"+data[i].name+"</dt>";
                    for (var j=0;j<data[i].children.length;j++) {
                        result+="<dd>"+data[i].children[j].name+"</dd>"
                    }
                    result+="</dl>"
                }
                $("body").html(result);
            })
        })
    </script>
</head>
<body>
登录成功
</body>
</html>
