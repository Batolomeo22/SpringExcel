<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<html>
<link rel="stylesheet" href="../statics/css/common/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../statics/css/common/fileinput.css" media="all"  type="text/css" />


<script src="../statics/js/common/jquery-3.5.1.min.js"></script>

<script src="../statics/js/common/bootstrap.js"></script>
<script src="../statics/js/file_input/fileinput.js"></script>
<script src="../statics/js/file_input/locale/zh.js"></script>

<head>
    <title>上传Excel</title>
</head>
<body>
<div class="col-sm-12 col-md-12">
    <input id="uploadFile" type="file" name="excelFile" multiple data-min-file-count="1">
</div>
<script>
    $(document).ready(function() {
        //console.log("${basePath}")
        initFileUpload('uploadFile');
    });

    function initFileUpload(idName){
        $("#" + idName + "").fileinput({
            language: 'zh', //设置语言
            uploadUrl: "${basePath}" + '/excel/importFile', //上传的地址
            showUpload: true,
            allowedFileExtensions : ['xls', 'xlsx'],
            uploadAsync : true,
            maxFileCount: 1,
            browseOnZoneClick: true,
            dropZoneEnabled : true,
            showPreview : true,
            enctype: 'multipart/form-data',
            showCaption: true,//是否显示标题
            browseClass: "btn btn-info", //按钮样式
            dropZoneEnabled: false,
            showPreview: true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        });
    }

    $("#uploadFile").on("fileuploaded", function (event, data, previewId, index) {
        console.log(data);
        if(data.response.flag == true)
        {
            alert(data.files[index].name + "上传成功!");
            //关闭
            $(".close").click();
        }
        else{
            alert(data.files[index].name + "上传失败!" + data.response.message);
            //重置
            $("#uploadFile").fileinput("clear");
            $("#uploadFile").fileinput("reset");
            $('#uploadFile').fileinput('refresh');
            $('#uploadFile').fileinput('enable');
        }
    });
</script>
</body>
</html>
