(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});
    appcan.button("#Button11", "ani-act", function() {
                upload();
                
      });
    appcan.ready(function() {
        $.scrollbox($("body")).on("releaseToReload",
        function() { //After Release or call reload function,we reset the bounce
            $("#ScrollContent").trigger("reload", this);
        }).on("onReloading",
        function(a) { //if onreloading status, drag will trigger this event
        }).on("dragToReload",
        function() { //drag over 30% of bounce height,will trigger this event
        }).on("draging",
        function(status) { //on draging, this event will be triggered.
        }).on("release",
        function() { //on draging, this event will be triggered.
        }).on("scrollbottom",
        function() { //on scroll bottom,this event will be triggered.you should get data from server
            $("#ScrollContent").trigger("more", this);
        }).hide();

    });
   
    
   function showdatas(msg){
    var lv = appcan.listview({
    selector : "#listviews",
    type : "thickLine",
    hasIcon :true,
    hasAngle : false,
    hasSubTitle :false,
    multiLine : 1,
    });
    lv.set([{
       title :msg["title"],
       icon :msg["icon"],
       id : "1"
   }]);
     lv.on("click",function(ele,obj,curEle){
     })
}
    
    function upload(){
        var uploadHttp = "http://192.168.43.126:8080/VisitorApp/SavePic";
        uexUploaderMgr.createUploader(1,uploadHttp);
    }
    
    window.uexOnload = function(){
        
        appcan.window.subscribe('cont', function(msg) {
           var ms=JSON.parse(msg);
            //alert(ms["title"]);
            showdatas(ms);
           appcan.locStorage.setVal('contactimage',ms["icon"]);
           appcan.locStorage.setVal('contactname',ms["title"]);
           appcan.locStorage.setVal('tels',ms["tel"]);
        });
        
        var upload_image_url = "";
        uexCamera.cbOpen = function(opCode, dataType, data){
            upload_image_url = data;
            document.getElementById("showPic").src = data;          
        }

        uexWidgetOne.cbError = function(opCode, errorCode, errorInfo){
            setLog(errorInfo);
        }
        uexUploaderMgr.cbCreateUploader =function(opCode,dataType,data){
            if(data == 0){  
            //  alert("创建成功");
            //  alert(document.getElementById('showPic').src);
                uexUploaderMgr.uploadFile(1,upload_image_url,"Pic",0); 
                uexWindow.toast(1,5,"头像上传ing...",0);
            }else{
            //  alert("创建失败");
            }
        }
        uexUploaderMgr.onStatus = function(opCode,fileSize,percent,serverPath,status){
            switch (status) {
                    case 0:
                        //setLog("上传进度："+percent+"%");
                        break;
                    case 1:
                        //setLog(serverPath);
                        uexWindow.closeToast();//关闭提示消息框
                        uexWindow.toast(0,5,"设置成功~",2000);
                        //uexWindow.closeToast();//关闭提示消息框
                        uexUploaderMgr.closeUploader(1);
                        inputinform();
                        break;
                    case 2:
                        //setLog("上传出错");
                        uexWindow.closeToast();//关闭提示消息框
                        uexWindow.toast(0,5,"出错啦~",2000);
                        //uexWindow.closeToast();//关闭提示消息框
                        uexUploaderMgr.closeUploader(1);
                        break;

            }
            
        }
    }
    function inputinform(){
                 
                 var ContactMessageuserid=$("#tel").val();
                 var contactimages=appcan.locStorage.getVal("contactimage");
                 var contactnames=appcan.locStorage.getVal("contactname");
                 var usernames=appcan.locStorage.getVal("username");
                 var reasons =$("#inreason").val();
                 var tels=appcan.locStorage.getVal("tels");
                 var times =$("#time").val();
                 var comments=$("#comments").val();
                 var userimgs=appcan.locStorage.getVal("userimg");
                 
                 var sendData={
                        userid:ContactMessageuserid,
                        contactname:contactnames,
                        username:usernames,
                        reason:reasons,
                        tel:tels,
                        time:times,
                        contactimg:contactimages,
                        userimg:userimgs,
                        comment:comments
                 };
          appcan.ajax({
              url:"http://192.168.43.126:8080/VisitorApp/SendVisitorReq", 
              type:'post',
              data:sendData,
              contentType : "application/json",
              dataType:"json",
              success:function(data){
                     appcan.window.alert("发送成功，等待对方确认","","确认","");
                     // appcan.window.openToast("注册成功","3000",5,0);
                     
             },
             error:function(xhr,status,errMessage) {
               appcan.window.openToast("ajax error","3000",5,0);
               }
           })
    
	}
})($);