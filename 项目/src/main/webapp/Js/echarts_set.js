var date = null;
var date1 = ['2/7', '2/10', '2/13'];
var chinaAddSure = null;
var chinaNowSure = null;
var chinaAddSave = null;
var chinaAddDied = null;
var d1 = $.Deferred();
var d2 = $.Deferred();
var d3 = $.Deferred();
var d4 = $.Deferred();
var d5 = $.Deferred();
function send() {
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaDate",
        dataType: "json",
        success: function (response) {
            date = response.data;
            d1.resolve("Fish")
        }
    });
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaAddSure",
        dataType: "json",
        success: function (response) {
            chinaAddSure = response.data;
            d2.resolve("Fish")
        }
    });
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaNowSure",
        dataType: "json",
        success: function (response) {
            chinaNowSure = response.data;
            d3.resolve("Fish")
        }
    });
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaAddSave",
        dataType: "json",
        success: function (response) {
            chinaAddSave = response.data;
            d4.resolve("Fish")
        }
    });
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaAddDied",
        dataType: "json",
        success: function (response) {
            chinaAddDied = response.data;
            d5.resolve("Fish")
        }
    });
}
send();
$.when( d1,d2,d3,d4,d5).done(function ( d1,d2,d3,d4,d5) {
    var china_new_zeng = echarts.init(document.getElementById('china_new_zeng'));
    var china_now_had = echarts.init(document.getElementById('china_now_had'));
    var china_now_dohad = echarts.init(document.getElementById('china_now_dohad'));
    var china_save = echarts.init(document.getElementById('china_save'));
    var china_died = echarts.init(document.getElementById('china_died'));
    //-------------------------------------
    var not_hubei_new = echarts.init(document.getElementById('not_hubei_new'));
    var hubei_new = echarts.init(document.getElementById('hubei_new'));
    var hubei_have = echarts.init(document.getElementById('hubei_have'));
    var not_hubei_have = echarts.init(document.getElementById('not_hubei_have'));
    //-----------------------------------------------------------------------------
    var china_new_zeng_option = {
        backgroundColor: '#e3e7f3',
        title: {
            text: '近期全国疫情新增趋势图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['新增确诊'],
            top: 22,
            left: 0
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data:  date
        },
        yAxis: {
            axisLabel: {
                show: true,
                textStyle: {
                    fontSize: 9
                }
            },
            type: 'value'
        },
        series: [

            {
                name: '新增确诊',
                smooth: true,
                type: 'line',
                data: chinaAddSure
            }
        ]
    };

    var china_now_had_option = {
        backgroundColor: '#f3bab0',
        title: {
            text: '近期全国疫情现存确诊趋势图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['现存确诊'],
            top: 22,
            left: 0
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {

            type: 'value'
        },
        series: [{
                name: '现存确诊',
                type: 'line',
                smooth: true,
                stack: '总量',
                data: chinaNowSure
            },



        ]
    };
    var china_save_option = {
        backgroundColor: '#95db9a',
        title: {
            text: '近期全国疫情治愈趋势图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['治愈'],
            top: 22,
            left: 0
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {

            type: 'value'
        },
        series: [{
                name: '治愈',
                type: 'line',
                smooth: true,
                stack: '总量',
                data: chinaAddSave
            },



        ]
    };
    var china_died_option = {
        backgroundColor: '#b4c0d5',
        title: {
            text: '近期全国疫情死亡趋势图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['死亡'],
            top: 22,
            left: 0
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {

            type: 'value'
        },
        series: [{
                name: '死亡',
                type: 'line',
                smooth: true,
                stack: '总量',
                data: chinaAddDied
            },



        ]
    };
    //-----------------------------------//

    //--------------------------------------------------
    china_new_zeng.setOption(china_new_zeng_option);
    china_now_had.setOption(china_now_had_option);
    china_now_dohad.setOption(china_now_dohad_option);
    china_save.setOption(china_save_option);
    china_died.setOption(china_died_option);

})

  

//--------------------------------------------------
not_hubei_new.setOption(not_hubei_new_option);
hubei_new.setOption(hubei_new_option);
hubei_have.setOption(hubei_have_option);
not_hubei_have.setOption(not_hubei_have_option);

//--------------------------------------------------