(function($) {
    appcan.button("#nav-left", "btn-act",
    function() {});
    appcan.button("#nav-right", "btn-act",
    function() {});
    appcan.button("#searchContact", "ani-act", function() {
                searchc();
      });
     appcan.button("#addCback", "ani-act", function() {
          appcan.window.open("co",'contact.html');
      });
  appcan.button("#btnadd", "ani-act", function() {
                add();
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
    
     
    function  searchc(){
        var userids=$("#searchnum").val();
         appcan.locStorage.setVal('useridc',userids);//存储人的账号
        var sendData={
            useridc:userids
        };
        appcan.ajax({
                url : "http://192.168.43.126:8080/VisitorApp/searchContact",
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                  showDataList(data);
                  
                  appcan.locStorage.setVal('username',data["username"]);
                  appcan.locStorage.setVal('state',data["state"]);
                  appcan.locStorage.setVal('usercontimg',data["usercontimg"]);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.alert("无此联系人，请重新搜索","","确认");
                }
            })
    }

	function showDataList(data){
        var lv = appcan.listview({
            selector : "#listview",
            type : "thickLine",
            hasIcon : false,
            hasAngle : false,
            hasSubTitle : true,
            multiLine : 1,
        });
        lv.set([{
            title : "姓名",
            subTitle : data["username"]
        }, {
            title : "状态",
            subTitle : data["state"]
        }])
        lv.on("click", function(ele, obj, curEle) {
            
        })
     }
     function add(){
          var usernames=appcan.locStorage.getVal("username") ;
          var state=appcan.locStorage.getVal("state");
          var userids=appcan.locStorage.getVal("userid");
          var usercontimgs=appcan.locStorage.getVal("usercontimg");
          var contacttels=appcan.locStorage.getVal("useridc");
          var sendData={
              userid:userids,
              contacttel:contacttels,
              username:usernames,
              usercontimg:usercontimgs,
              state:state
          };
          var myIp="http://192.168.43.126:8080/VisitorApp/addContact";
          appcan.ajax({
                url : myIp,
                type : 'post',
                data:sendData,
                contentType : "application/json",
                dataType : 'json',
                success : function(data) {
                    appcan.window.alert("添加成功！"," ","确定",0);
                },
                error : function(xhr, status, errMessage) {
                    appcan.window.openToast("获取数据失败，请检查网络");
                }
            })
   
     }
})($);