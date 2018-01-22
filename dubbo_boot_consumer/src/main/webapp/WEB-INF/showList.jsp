<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<br><br>

<table id="showList"></table>

<script type="text/javascript">
    //查询
    $(function(){
        $("#showList").bootstrapTable({
            url:"<%=request.getContextPath()%>/queryUserdata.do",
            method:"get",
            striped: true,  	// 斑马线效果     默认false
            //只允许选中一行
            singleSelect:true,
            //选中行是不选中复选框或者单选按钮
            clickToSelect:true,
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            uniqueId: "userid",                 //每一行的唯一标识，一般为主键列
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,     //  最少留两列
            detailView: false,                  //是否显示父子表
            //发送到服务器的数据编码类型  userid, username, userpwd, usernike, usersex
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
            columns:[
                {field:'userid',title:'序号', class:'active',width:50,
                    formatter:function(value,row,index){   //  格式化  当前单元格内容
                        return "<input type='checkbox' value="+value+" name='cho'/>";
                    }},
                {field:'usernike',title:'会员名称', class:'success',width:100},
                {field:'username',title:'登录名', class:'warning',width:100},
                {field:'userpwd',title:'登录密码', class:'warning',width:100},
                {field:'usersex',title:'性别', class:'info',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "男";
                        }
                        if(value == 2){
                            return "女";
                        }}},
                {field:'usercdate',title:'账号创建时间', class:'active',width:100,
                    formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
                        var simfomat = new Date();
                        simfomat.setTime(value);   //转换时间
                        return  simfomat.toLocaleDateString();
                    }
                },
            ],
            //传递参数（*）
            queryParams: function(params) {
                var whereParams = {
                    /*
                        分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）
                    */
                    "pageSize":params.limit,
                    "start":params.offset,
                    //"shopname":params.search,//精确搜索产品名称
                }
                return whereParams;
            },
            //前台--排序字段
            //sortName:'proPrice',
            //sortOrder:'desc',
            //前台--搜索框
            search:true,
            //启动回车键做搜索功能
            searchOnEnterKey:true,
            //分页方式   后台请求的分页方式
            sidePagination:'server',
            pagination: true,                   //是否显示分页（*）
            pageNum: 1,                       //每页的记录行数（*）
            pageSize: 3,                       //每页的记录行数（*）
            pageList: [3, 6, 9,12],        //可供选择的每页的行数（*）
        })
    })

</script>
</body>
</html>