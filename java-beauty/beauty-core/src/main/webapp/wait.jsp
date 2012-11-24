<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>   
<%@taglib prefix="s"uri="/struts-tags"%>   
<!DOCTYPEHTMLPUBLIC"-//W3C//DTDHTML4.01Transitional//EN">   
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">   
<meta http-equiv="refresh" content="1;url=<s:url includeParams="none" />"/>   
<title> 
</title> 
</head> 
<body> 
<h1>数据处理中,请稍等......</h1> 
process:${process }  total:${total } 
<br> 
如果没有自动跳转请<a href="<s:url includeParams="all" />">点这里</a>. 
<!-- 
其中的includeParams参数取值为：<br> 
none,不把参数加入到url参数中<br> 
all,是把get和post中的参数加入到url参数中<br> 
get,是只把get中的参数加入到url参数中
 --> 
</body> 
</html>