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
        }).reload();
    })

    var listview_MultiListView_8g9z0b = appcan.listview({
        selector: $("#MultiListView_8g9z0b"),
        type: "thickLine",
        hasAngle: false || false,
        hasIcon: false || false,
        align: "left" || "left",
        hasRadiobox: false || false,
        hasCheckbox: false || false,
        hasSubTitle: false || false,
        multiLine: 1 || 1,
    });

    listview_MultiListView_8g9z0b.set([{
        "title": "临时数据",
        "describe": "测试",
        "note": "测试",
        "icon": "css/res/appcan_s.png",
        "icontitle": "appcan",
        "subTitle": "-195.3",
        "subDescribe": "缺货",
        "subNote": "北京",
        "id": "1"
    },
    {
        "title": "临时数据",
        "describe": "测试",
        "note": "测试",
        "icon": "css/res/appcan_s.png",
        "icontitle": "appcan",
        "subTitle": "-195.3",
        "subDescribe": "缺货",
        "subNote": "北京",
        "id": "2"
    }]);
})($);