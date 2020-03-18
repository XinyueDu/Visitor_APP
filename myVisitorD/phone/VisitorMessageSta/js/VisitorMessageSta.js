(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});
    appcan.button("#handle", "btn-act",
    function() {
        appcan.locStorage.getVal("visitorstate","处理");
        appcan.window.close(-1);
         appcan.window.alert("门禁已开启","","确认",0);
         //appcan.window.evaluateScript("VisitorMessage",'SendState(1)'); 
         SendState(1);
    });
    
    appcan.button("#amend", "btn-act",
    function() {
        appcan.locStorage.getVal("visitorstate","改约");
        appcan.window.close(-1);
        appcan.window.alert("改约，门禁不开启","","确认",0);
        //appcan.window.evaluateScript("VisitorMessage",'SendState(2)'); 
        SendState(2);
    });
    appcan.button("#cancel", "btn-act",
    function() {
        appcan.locStorage.getVal("visitorstate","取消");
        appcan.window.close(-1);
        appcan.window.alert("取消，门禁不开启","","确认",0);
        //appcan.window.evaluateScript("VisitorMessage",'SendState(3)'); 
        SendState(3);
    });
    appcan.button("#refuse", "btn-act",
    function() {
        appcan.locStorage.getVal("visitorstate","拒绝");
        appcan.window.close(-1);
        appcan.window.alert("拒绝，门禁不开启","","确认",0);
        //appcan.window.evaluateScript("VisitorMessage",'SendState(4)'); 
        SendState(4);
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
    })
	
	function SendState(state){
        var messageids=appcan.locStorage.getVal("messageid");
        if(state==1){
          var sendData={
              messageid:messageids,
              states:"已处理"
          };
          appcan.window.evaluateScript("vm","ChangeState('已处理')");
          //$('stateText').val("已处理");
        }
        else if(state==2){
          var sendData={
              messageid:messageids,
              states:"改约"
          };
          appcan.window.evaluateScript("vm","ChangeState('改约')");
          //$('stateText').val("改约");
        }
        else if(state==3){
          var sendData={
              messageid:messageids,
              states:"取消"
          };
          appcan.window.evaluateScript("vm","ChangeState('取消')");
          //$('stateText').val("取消");
        }
        else if(state==4){
          var sendData={
              messageid:messageids,
              states:"拒绝"
          };
          appcan.window.evaluateScript("vm","ChangeState('拒绝')");
          //$('stateText').val("拒绝");
        }
        appcan.ajax({
                url : "http://192.168.43.126:8080/VisitorApp/UpdateMessageState",
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                   
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
       })
    }
	
})($);