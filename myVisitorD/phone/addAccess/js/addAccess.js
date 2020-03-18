(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});
    appcan.button("#monitor", "ani-act", function() {
                mon();
          })
   appcan.button("#Button11", "ani-act", function() {
              bind();  
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
    /*var lv2 = appcan.listview({
            selector : "#listview2",
            type : "thinLine",
            hasIcon : false,
            hasAngle : false,
            hasSubTitle : true,
            multiLine : 1
        });
        lv2.set([{
            title : "名称",
            subTitle : 'bat'
        }, {
            title : "型号",
            subTitle : '879465415641131131'
        }, {
            title : '<div class="ub-f1 ut-s t-gra-FS1 ulev-app1">地址</div>',
            subTitle : '<div class=" bc-text ">西安科技大学</div>'
        }])*/
         
         function mon(){
             
              appcan.ajax({
                url : "http://192.168.43.126:8080/VisitorApp/getAccessInfo",
                type : 'post',
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                  showDataList(data);
                  
                  appcan.locStorage.setVal('accessname',data["accessname"]);
                  appcan.locStorage.setVal('address',data["address"]);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
            })
         }
         
         function showDataList(data){
        var lv = appcan.listview({
            selector : "#listview2",
            type : "thickLine",
            hasIcon : false,
            hasAngle : false,
            hasSubTitle : true,
            multiLine : 1,
        });
        lv.set([{
            title : "名称",
            subTitle : data["accessname"]
        }, {
            title : "型号",
            subTitle : data["accesstype"]
        }, {
            title : '地址',
            subTitle :data["address"]
        }])
      
 
        lv.on("click", function(ele, obj, curEle) {
            
        })
     }
      
      function bind(){
          var accessnames=appcan.locStorage.getVal("accessname") ;
          var addresses=appcan.locStorage.getVal("address") ;
          var userids=appcan.locStorage.getVal("userid") ;
          var sendData={
              userid:userids,
              accessname:accessnames,
              address:addresses
          };
          var myIp="http://192.168.43.126:8080/VisitorApp/blindAccess";
          appcan.ajax({
                url : myIp,
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                    appcan.window.alert("绑定成功！"," ","确定",0);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
            })
      }
            
})($);