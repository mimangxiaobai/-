

$(()=>{
    var map_china_now = null;
    var map_china_tol_data = null;
    var map_world_now_data = null;
    var map_world_tol_data = null;
    var done1 = $.Deferred();
    var done2 = $.Deferred();
    var done3 = $.Deferred();
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListChinaNowData",
        dataType: "json",
        success: function (response) {
            map_china_now_data =  response.data;
            done1.resolve( "Fish" )
        }
    });
    $.when( done1).done(function ( done1) {  
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListChinaTotalData",
            dataType: "json",
            success: function (response) {
                map_china_tol_data =  response.data;
                done2.resolve( "Fish" )
            }
        });
    });  
    $.when( done2).done(function ( done2) {  
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListWorldNowData",
            dataType: "json",
            success: function (response) {
                map_world_now_data =  response.data;
                done3.resolve( "Fish" )
            }
        });
    });  
    $.when( done3).done(function ( done3) {  
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListWorldTotalData",
            dataType: "json",
            success: function (response) {
                console.log(response)
                map_world_tol_data =  response.data;
            }
        });
    });  
   

//国外确诊
var chart = Highcharts.chart('world_new', {
    chart: {
        type: 'spline'
    },
    title: {
        text: '全球疫情确诊趋势图'
    },

    subtitle: {
        text: ''
    },
    xAxis: {
        categories: ['01-19', '01-25', '01-31', '02-06', '02-12', '02-18',
            '02-24', '03-02', '03-08', '03-14', '03-20', '03-26'
        ]
    },
    yAxis: {
        title: {
            text: ''
        },
        labels: {
            formatter: function () {
                return this.value + '°';
            }
        }
    },
    tooltip: {
        crosshairs: true,
        shared: true
    },
    plotOptions: {
        spline: {
            marker: {
                radius: 4,
                lineColor: '#666666',
                lineWidth: 1
            }
        }
    },
    series: [{
        name: '中国',
        marker: {
            symbol: 'square'
        },
        data: [0, 2500, 5000, 4900, 5600.7000, 6500, 18000, {
            y: 3000,

        }, 0, 0, 0, 0]
    }, {
        name: '其他国家',
        marker: {
            symbol: 'diamond'
        },
        data: [{
            y: 0

        }, 0, 0, 0, 0, 0, 0, 100, 4000, 8000, 1200, 40000]
    }]
});


// 初始化图表

//国外累计
//-------------------------------------------------------
// 初始化图表

setTimeout(() => {
    var map = new Highcharts.Map('map_china_now', {
        title: {
            text: '中国现存确诊'
        },
        mapNavigation: {
            enabled: true,
            enableButtons: false,
            enableTouchZoom: false,
            enableDoubleClickZoomTo: true
        },
        colorAxis: {
            min: 0,
            minColor: 'rgb(255,255,255)',
            maxColor: '#6d293a',
    
            max:80,
        },
        legend: {
            align: 'left',
            verticalAlign: 'top',
            floating: true,
            x: 0,
            y: -20
        },
        colorAxis: {
            dataClasses: [{
                to: 1,
                color: 'white',
            }, {
                from: 1,
                to: 9,
                color: '#f2ab9a',
            }, {
                from: 9,
                to: 99,
                color: '#f96c4e',
            }, {
                from: 99,
                to: 999,
                color: '#f13c10',
            }, {
                from: 999,
                color: '#500b00',
            }],
    
        },
        series: [{
            data: map_china_now_data,
            name: '现存确诊',
            mapData: Highcharts.maps['cn/china'],
            joinBy: 'name' // 根据 name 属性进行关联
        }]
    });
    var map = new Highcharts.Map('map_china_tol', {
        title: {
            text: '中国累计确诊'
        },
        mapNavigation: {
            enabled: true,
            enableButtons: false,
            enableTouchZoom: false,
            enableDoubleClickZoomTo: true
        },
        legend: {
            align: 'left',
            verticalAlign: 'top',
            floating: true,
            x: 0,
            y: -20
        },
        colorAxis: {
            dataClasses: [{
                to: 1,
                color: 'white',
            }, {
                from: 1,
                to: 59,
                color: '#f2ab9a',
            }, {
                from: 59,
                to: 599,
                color: '#f96c4e',
            }, {
                from: 599,
                to: 2999,
                color: '#f13c10',
            }, {
                from: 2999,
                color: '#500b00',
            }],
    
        },
        series: [{
            data: map_china_tol_data,
            name: '累计h确诊',
            mapData: Highcharts.maps['cn/china'],
            joinBy: 'name' // 根据 name 属性进行关联
        }]
    });
    var map = new Highcharts.Map('map_world_now', {
        title: {
            text: '国外现存确诊'
        },
        mapNavigation: {
            enabled: true,
            enableButtons: false,
            enableTouchZoom: false,
            enableDoubleClickZoomTo: true
        },
        colorAxis: {
            min: 0,
            minColor: 'rgb(255,255,255)',
            maxColor: '#6d293a',
    
            max:80,
        },
        legend: {
            align: 'left',
            verticalAlign: 'top',
            floating: true,
            x: 0,
            y: -20
        },
        colorAxis: {
            dataClasses: [{
                to: 0,
                color: 'white',
            }, {
                from: 9,
                to: 99,
                color: '#f2ab9a',
            }, {
                from: 99,
                to: 999,
                color: '#f96c4e',
            }, {
                from: 999,
                to: 9999,
                color: '#f13c10',
            }, {
                from: 9999,
                color: '#500b00',
            }],
    
        },
        series: [{
            data: map_world_now_data,
            name: '现存确诊',
            mapData: Highcharts.maps['custom/world-highres2'],
            joinBy: 'name' // 根据 name 属性进行关联
        }]
    });
    var map = new Highcharts.Map('map_world_tol', {
        title: {
            text: '国外累计确诊'
        },
        mapNavigation: {
            enabled: true,
            enableButtons: false,
            enableTouchZoom: false,
            enableDoubleClickZoomTo: true
        },
        // colorAxis: {
        //     min: 0,
        //     minColor: 'rgb(255,255,255)',
        //     maxColor: '#6d293a',
    
        //     max:80,
        // },
        legend: {
            align: 'left',
            verticalAlign: 'top',
            floating: true,
            x: 0,
            y: -20
        },
        colorAxis: {
            dataClasses: [{
                to: 0,
                color: 'white',
            }, {
                from: 9,
                to: 99,
                color: '#f2ab9a',
            }, {
                from: 99,
                to: 999,
                color: '#f96c4e',
            }, {
                from: 999,
                to: 9999,
                color: '#f13c10',
            }, {
                from: 9999,
                color: '#500b00',
            }],
    
        },
        series: [{
            data: map_world_tol_data,
            name: '累计确诊',
            mapData: Highcharts.maps['custom/world-highres2'],
            joinBy: 'name' // 根据 name 属性进行关联
        }]
    });
}, 3000);
// 初始化图表

//中国累计
//-------------------------------------------------------
// 初始化图表

//-------------------------------------------------------
})

