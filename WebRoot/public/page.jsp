<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 当前第[${page.pagenum }]页&nbsp;&nbsp;&nbsp;
    
    <c:if test="${page.pagenum>1}">
    <a href="${page.url }?pagenum=${page.pagenum-1 }">上一页</a>
    </c:if>
    &nbsp;
	<c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
		[<a href="${page.url }?pagenum=${pagenum}">${pagenum }</a>]
	</c:forEach>  
	&nbsp;
	
	<c:if test="${page.pagenum<page.totalpage}">
	<a href="${page.url }?pagenum=${page.pagenum+1 }">下一页</a>
	</c:if>
	
	&nbsp;&nbsp;&nbsp;
	共[${page.totalpage }]页,共[${page.totalrecord}]纪录,
	
	<input type="text" style="width: 30px" id="pagenum">
	<input type="button" value=" GO " onclick="goWhich(document.getElementById('pagenum'))">
	
	<script type="text/javascript">
		function goWhich(input){
			var pagenum = input.value;
			if(pagenum==null || pagenum==""){
				alert("请输入页码！");
				return;
			}
			
			if(!pagenum.match("\\d+")){
				alert("请输入数字！");
				input.value="";
				return;
			}
			
			if(pagenum<1 || pagenum>${page.totalpage}){
				alert("无效的页码！");
				input.value="";
				return;
			}
			window.location.href="${page.url }?pagenum=" + pagenum;
		}
	</script>
