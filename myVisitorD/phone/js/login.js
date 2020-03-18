(function($) {
        appcan.button("#Button2", "ani-act", function() {
            appcan.window.close(-1);
            appcan.window.open({
                name:'re',
                data:'re.html',
                //aniId:2,
                //animDuration:500
                
            });
              })
            appcan.button("#Button1", "ani-act", function() {
                login();
              })
        function login () { 
            //获取用户名，用户密码
          var userids =$("#userid").val();
          var passwords =$("#password").val();//存用户储的账号
          var sendData={
              userid:userids,
              password:passwords
          };
          //var post_data = [{"userid":userids,"password":passwords}];
          //userID=data.data[0].userID;
          //passWord=data.data[0].password;
                                 // appcan.window.open({
                         // name:'me',
                         // data:'message.html',
                         // aniId:2,
                         // });  
                         // if(data.status=="0"){
                      // userID=data.data[0].id;
                      // name=data.data[0].name;
//                       
                     // var obj=JSON.stringify(data.data); 
//                      
                      // appcan.locStorage.setVal('userID'.userID);
                      // appcan.locStorage.setVal('photoID',photoID);
                      // appcan.locStorage.setVal('name',name);
//                       
                 // }
                  // else{
                      // appcan.window.openToast("手机号或密码错误","3000",5,0);
                  // }appcan.window.open("me",'message.html',10);var Result=JSON.parse(data);
         var myIp="http://192.168.43.126:8080/VisitorApp/Login";
          appcan.ajax({
              url:myIp, //?userid="+userid+"&password="+password,
              type:'post',
              data:sendData,
              contentType : "application/json",
              dataType:"json",
              success:function(data){
                  appcan.locStorage.setVal('userid',data["userid"]);
                  appcan.locStorage.setVal('username',data["username"]);
                  appcan.locStorage.setVal('userimg',data["userimg"]);
                  appcan.window.open("me",'message.html');
                 
                  },
              error:function(xhr,status,errMessage) {
                appcan.window.alert("手机号或密码错误","","确认",0);
              }
          })
        }

})($);