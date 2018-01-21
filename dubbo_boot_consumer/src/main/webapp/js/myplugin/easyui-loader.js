function myLoader(param,success,error){
    var that = $(this);
    var opts = that.datagrid("options");
    if (!opts.url) {
        return false;
    }
    var cache = that.data().datagrid.cache;
    if (!cache) {
        $.ajax({
            type : opts.method,
            url : opts.url,
            data : param,
            dataType : "json",
            success : function (data) {
                that.data().datagrid['cache'] = data;
                success(bulidData(data));
            },
            error : function () {
                error.apply(this, arguments);
            }
        });
    } else {
        success(bulidData(cache));
    }

    function bulidData(data) {
        var temp = $.extend({},data);
        var tempRows = [];
        var start = (param.page - 1) * parseInt(param.rows);
        var end = start + parseInt(param.rows);
        var rows = data.rows;
        for (var i = start; i < end; i++) {
            if(rows[i]){
                tempRows.push(rows[i]);
            }else{
                break;
            }
        }
        temp.rows = tempRows;
        return temp;
    }
}