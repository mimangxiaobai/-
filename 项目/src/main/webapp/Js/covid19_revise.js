$(()=>{
    var covid_revise_con  = new Swiper('.covid_revise_con', {
        on: {
            slideChangeTransitionStart: function() {
                $(".tabs .active").removeClass('active');
                $(".tabs a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs a").on('click', function(e) {
        e.preventDefault()
        $(".tabs .active").removeClass('active')
        $(this).addClass('active')
        covid_revise_con.slideTo($(this).index())
    })
})
$(window).resize(function () {
    window.location.reload();
  });
$("#saveCovidData").click(function (e) { 
    $("#fix_load").show();
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "/covid19-show/SaveCovidData",
        data: $("#saveCovidDataForm").serialize(),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error:function (res) {
            $("#fix_load").html("修改失败");
            $("#fix_load").hide();
        }
    });
});
$("#saveFormCovidData").click(function (e) { 
    $("#fix_load").show();
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "/covid19-show/SaveForeignCovidData",
        data: $("#saveFormCovidDataForm").serialize(),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error:function (res) {
            $("#fix_load").html("修改失败");
            $("#fix_load").hide();
        }
    });
});
$("#getChinaData").click((e)=>{
    window.open("/covid19-show/GetChinaDataExcel");
    // $.ajax({
    //     type: "POST",
    //     url: "/covid19-show/GetChinaDataExcel",
    //     dataType:"application/vnd.ms-excel",
    //     success: function (response) {
            
    //     }
    // });
})
$("#getWorldData").click((e)=>{
    window.open("/covid19-show/GetWorldDataExcel");
    // $.ajax({
    //     type: "POST",
    //     url: "/covid19-show/GetChinaDataExcel",
    //     dataType:"application/vnd.ms-excel",
    //     success: function (response) {
            
    //     }
    // });
})
$("#postChinaData").click((e)=>{
    $("#fix_load").show();
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "/covid19-show/ReadChinaDataExcel",
        processData: false,
        contentType: false,
        data:  new FormData($("#postChinaDataForm")[0]),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error:function () {
            $("#fix_load").html("修改失败");
            $("#fix_load").hide();
        }
    });
})
$("#postWorldData").click((e)=>{
    $("#fix_load").show();
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "/covid19-show/ReadWorldDataExcel",
        processData: false,
        contentType: false,
        data:  new FormData($("#postWorldDataForm")[0]),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error:function () {
            $("#fix_load").html("修改失败");
            $("#fix_load").hide();
        }
    });
})
