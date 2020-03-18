(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});
    appcan.button(".switch", "btn-act",
      function() {
          
          });
    appcan.switchBtn(".switch", function(obj, value) {
        //alert(value);
        if(value==true){
            appcan.locStorage.setVal("IsState","可访");
            upState();
        }
        else{
            appcan.locStorage.setVal("IsState","不可访");
            upState();
        }
      // var tag=true;  
      // $(".switch").on('click',function(){  
//         var obj=$(this);  
//        "false" == obj.attr("data-checked") ? obj.addClass("bc-head") : obj.removeClass("bc-head");  
//       if(tag){  
//            obj.attr("data-checked","true");  
//            tag=false; 
          // appcan.locStorage.setVal("IsState","可访");
//       }  
//      else{  
//            obj.attr("data-checked","false");  
//            tag=true; 
          // appcan.locStorage.setVal("IsState","不可访");
//      } );
    })
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
    })
     function upState(){
          var states=appcan.locStorage.getVal("IsState") ;
          var stateuserid=appcan.locStorage.getVal("userid") ;
          var sendData={
              userid:stateuserid,
              state:states
          };
          var myIp="http://192.168.43.126:8080/VisitorApp/updataState";
          appcan.ajax({
                url : myIp,
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                    appcan.window.alert("修改成功！"," ","确定",0);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
            })
      }
})($);