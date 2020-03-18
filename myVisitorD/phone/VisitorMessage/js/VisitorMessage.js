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
        // subDescribe:data["\"state"+i+"\""]  icon:data["\"image"+i+"\""],
       // appcan.window.subscribe('Mess', function(msg) {
           // var ms=JSON.parse(msg);
            // alert(ms.tel);
            // showData(ms);
        // });
        //showData();
    });
    
    window.uexOnload = function(){
        
        appcan.window.subscribe('mess', function(msg) {
           var ms=JSON.parse(msg);
            //alert(ms.tel);
            showData(ms);
            appcan.locStorage.setVal("messageid",ms.messageid);
        });
        
    }
    
    function showData(msg){
        var lv = appcan.listview({
        selector : "#listview1",
        type : "thickLine",
        hasIcon : false,
        hasAngle : false,
        hasSubTitle :true,
        multiLine : 1,
        });
        
        document.getElementById("reqImg").src = msg.photo;
        $('textarea').val(""+msg.comments+"");
           lv.set([{
            title : '<div class=" ub umar-l1 umh5 ub-ac">'+msg["title"]+'</div>',
            describe:'<div class=" ub umar-l1 umh4 ub-ac"> Time：'+msg.subTitle+'</div>',
            subTitle:""+msg.subDescribe+"",
            id:"1"
        }]);
        lv.on("click",function(ele,obj,curEle){
        })

        var lv = appcan.listview({
            selector : "#listview2",
            type : "thickLine",
            hasAngle :false
        });
        lv.set([{
            title : '<div class=" ub umar-l1 umh4 ub-ac">'+msg.describe+' </div>',
            id:"1"
        }, {
            title : '<div class=" ub umar-l1 umh4 ub-ac">手机号：'+msg.tel+' </div>',
            id:""
        }]);
        lv.on("click",function(ele,obj,curEle){
        })
    }
    
        
})($);