<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
     uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
     response.setHeader("Pragma", "no-cache");
     response.setHeader("Cache-Control", "no-cache");
     response.setDateHeader("Expires", 0);
%>
<html>
    <head>
        <title><decorator:title default="kangxm test" />
        </title>
        <!-- 页面Head由引用模板的子页面来替换 -->
        <decorator:head />
    </head>
    <body id="page-home">
        <div id="page-total">
            <div id="page-header">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>
                            <div class="topFunc">
                                 我的账户
                                 |
                                 退出
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- end header -->
        <!--   Menu Tag begin -->
        <div id="page-menu" style="margin-top: 8px; margin-bottom: 8px;">
            <div>
                 这里放菜单
            </div>
        </div>
        <!--   Menu Tag end -->
        <div id="page-content" class="clearfix">
            <center>
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>
                            <decorator:body /><!-- 这里的内容由引用模板的子页面来替换 -->
                        </td>
                    </tr>
                </table>
            </center>
        </div>
        <!-- end content -->
        <div id="page-footer" class="clearfix">

             这里放页面底部
            <!-- end footer -->
        </div>
        <!-- end page -->
    </body>
</html>