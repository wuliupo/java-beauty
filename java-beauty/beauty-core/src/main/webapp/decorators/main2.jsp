<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %> 添加标签

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><decorator:title default="Welcome!" /></title>
    <decorator:head></decorator:head>     将目标jsp的标题包含到这里
  </head>
  
  <body style="text-align: center;">
  <div style="width: 1002px; height: 800px">
     <div id="top" style="width: 1000px; height: 140px; border:1px solid #000000; ">
         <br>
         <h3>欢 迎 光 临 传 我 的 站 点</h3><br>
         您还未登陆！ 请选择 <a href="#">登陆</a>或<a href="#">注册新用户</a>
     </div>
     
     <div id="left" style="width: 200px; height: 600px; border:1px solid #000000; float: left; ">
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
         <a href="#">javaee</a><br><br>
     </div>
     
     <div id="right" style="width: 800px; height: 600px; border:1px solid #000000; float: left;  ">
         <br><br><br>
         <decorator:body />
     </div>
     </div>
   <br><br>
  </body>
</html>