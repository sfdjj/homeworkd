var xmlhttp;
if(window.XMLHttpRequest) {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp = new XMLHttpRequest();
}else {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function()
{
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
        var resultModel =xmlhttp.response;
        var ret = resultModel.ret;
        if(ret) {
            var data = resultModel.data;
            var s = "<tr class=\"content-title\">\n" +
                "                      <th class=\"tableHead-title\">标题</th>\n" +
                "                      <th class=\"tableHead-number\">字数</th>\n" +
                "                      <th class=\"tableHead-cnNumber\">中文字数</th>\n" +
                "                      <th class=\"tableHead-enNumber\">英文字数</th>\n" +
                "                      <th class=\"tableHead-puncNumber\">标点符号数</th>\n" +
                "                  </tr>";
            for(var i=0;i<data.length;i++) {
                s = s+"<tr class=\"content-result\">"+
                    "<td class=\"article-title\">"+data[i].title+"</td>"+
                    "<td class=\"article-number\">"+data[i].number+"</td>"+
                    "<td class=\"article-cnNumber\">"+data[i].chNumber+"</td>"+
                    "<td class=\"article-enNumber\">"+data[i].enNumber+"</td>"+
                    "<td class=\"article-puncNumber\">"+data[i].puncNumber+"</td>"+
                    "</tr>";
            }
            document.getElementById("content").innerHTML=s;
            document.getElementById("page1").style.backgroundColor="#3982ff";
        }else{
            document.write(resultModel.errmsg);
        }
    }
}
xmlhttp.open("GET","/counter/getData?t="+Math.random(),true);
xmlhttp.responseType="json"
xmlhttp.send();

