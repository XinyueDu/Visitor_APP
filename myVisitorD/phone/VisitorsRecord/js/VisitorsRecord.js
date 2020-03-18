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
          appcan.ajax({
                url : "http://192.168.43.126:8080/VisitorApp/getVisitorsRecord",
                type : 'post',
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
        hasIcon : true,
        hasAngle : false,
        hasSubTitle : true,
        multiLine : 1,
        });

       var datalist=[];
        for(var i=0;i<data["num"];i++){
            
            var str={
                title:data["\"name"+i+"\""],
                describe:data["\"tel"+i+"\""],
                subTitle:data["\"data"+i+"\""]
            };
            datalist.push(str);
        }
        lv.set(datalist);
 
        lv.on("click", function(ele, obj, curEle) {
            
        })
   }

	
})($);