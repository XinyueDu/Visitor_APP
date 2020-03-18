(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});

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
        var userids=appcan.locStorage.getVal("userid") ;
          var sendData={
              userid:userids
          };
        appcan.ajax({
                url : "http://192.168.43.126:8080/VisitorApp/getAccess",
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                  showDataList(data);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
            })
    });
     function showDataList(data){
        var lv = appcan.listview({
            selector : "#listview",
            type : "thickLine",
            hasIcon :false,
            hasAngle : false,
            hasSubTitle : true,
            multiLine : 1,
        });

       var datalist=[];
        for(var i=0;i<data["num"];i++){
            var str={
                title:'<div style="height:0.6em"></div><span class=" umar-l1 ">名称：</span>'+data["\"accessname"+i+"\""],
                describe:'<span class=" umar-l1">地址：</span>'+data["\"address"+i+"\""]+'<div style="height:0.6em"></div>',
                subDescribe:'<div class="ub ub-ac ub-pc button  f-btn  bc-text-head d-size">删除</div>'
            };
            datalist.push(str);
        }
        lv.set(datalist);
 
        lv.on("click", function(ele, obj, curEle) {
            
        })
     }


	
})($);