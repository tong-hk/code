<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
		<%@include file="../include/header.jsp"%>
        <script language="javascript" type="text/javascript">
        function deleteRole(rid) {
            var r = window.confirm("确定要删除此角色吗？");
            if(r) {
            	location.href="${pageContext.request.contextPath}/role/deleteRoleAction.do?rid="+rid;
            }
            var msg = '${msg}';
            if(msg!=""){
            	$("#operate_result_info").append(msg);
            	$("#operate_result_info").css("display","block");
            }
           // document.getElementById("operate_result_info").style.display = "block";
        }
        function updateRole(rid) {
            location.href="${pageContext.request.contextPath}/role/updateShowRoleAction.do?rid="+rid;
        }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <%@include file="../include/navi.jsp"%> 
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/role/selectAllPriv.do';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                    
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>
                        <c:forEach items="${allRole}" var="role">                      
	                        <tr>
	                            <td>${role.id}</td>
	                            <td>${role.rname}</td>
	                            
	                            <td>
		                            <c:forEach items="${role.lp}" var="priv">
		                            	${priv.pname}
		                            </c:forEach>
	                            </td>
	                            
	                            <td>
	                                <input type="button" value="修改" class="btn_modify" onclick="updateRole('${role.id}');"/>
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole('${role.id}');" />
	                            </td>
	                        </tr>
	                     </c:forEach>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
