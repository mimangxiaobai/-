$(window).resize(function () {
    window.location.reload();
});

$(() => {
	
    let roulingMessage = null;
    $.ajax({
        type: "POST",
        url: "/covid19-show/ListRoulingMessage",
        dataType: "json",
        success: function (response) {
            roulingMessage = response.data
            let con = "<h3>预览：</h3>";
            for (let index = 0; index < response.data.length; index++) {
                con += `
                        <div>
                        标题:
                        ${response.data[index].title}

                    </div>
                    <div>
                        内容：
                        ${response.data[index].content}
                    </div>
                    `;
                     con+=`<hr>`

            }
           
            $("#roulingMessage").html(con);
        }
    });
})
var swiper = new Swiper('.swiper-container2', {
    pagination: {
        el: '.Pagination1',
        type: 'fraction',
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});
var new_revise_con = new Swiper('.new_revise_con', {
    on: {
        slideChangeTransitionStart: function () {
            $(".tabs .active").removeClass('active');
            $(".tabs a").eq(this.activeIndex).addClass('active');
        }
    }
})
$(".tabs a").on('click', function (e) {
    e.preventDefault()
    $(".tabs .active").removeClass('active')
    $(this).addClass('active')
    new_revise_con.slideTo($(this).index())
})


$("#news_revise_file").change(function (e) {
    console.log("------------------")
    e.preventDefault();

    var file = $("#news_revise_file")[0].files[0]
    var reader = new FileReader()
    reader.readAsDataURL(file)
    // 处理需要一些时间 所以之后的操作在onload 里写
    reader.onload = () => {
        let imgUrl = reader.result;
        console.log($("#show"))
        $("#show").attr('src', imgUrl);
    }
});

$("#news_revise_file2").change(function (e) {
    console.log("------------------")
    e.preventDefault();
    var file = $("#news_revise_file2")[0].files[0]
    var reader = new FileReader()
    reader.readAsDataURL(file)
    // 处理需要一些时间 所以之后的操作在onload 里写
    reader.onload = () => {
        let imgUrl = reader.result;
        console.log($("#show"))
        $("#show2").attr('src', imgUrl);
    }
});

$("#news_revise_file3").change(function (e) {
    console.log("------------------")
    e.preventDefault();

    var file = $("#news_revise_file3")[0].files[0]
    var reader = new FileReader()
    reader.readAsDataURL(file)
    // 处理需要一些时间 所以之后的操作在onload 里写
    reader.onload = () => {
        let imgUrl = reader.result;
        console.log($("#show"))
        $("#show3").attr('src', imgUrl);
    }
});
$("#news_revise_file4").change(function (e) {
    console.log("------------------")
    e.preventDefault();
    var file = $("#news_revise_file4")[0].files[0]
    var reader = new FileReader()
    reader.readAsDataURL(file)
    // 处理需要一些时间 所以之后的操作在onload 里写
    reader.onload = () => {
        let imgUrl = reader.result;
        $("#show4").attr('src', imgUrl);
    }
});

$("#homeRoulingAdd").click(function (e) {
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/HomeRoulingSave",
        processData: false,
        contentType: false,
        data: new FormData($("#homeRoulingAddForm")[0]),
        dataType:"json",
        success: function (response) {
            let result = $.parseJSON(response);
            console.log(result);
            if (result.code == 200) {
                $("#fix_load").html("添加成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("添加失败");
                $("#fix_load").hide();
            }
        },
        error: function (response) {
            $("#fix_load").html("添加失败");
            $("#fix_load").hide();
        }
    });
});
$("#submit1").click(function (e) {
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/HomeRoulingUpdate",
        processData: false,
        contentType: false,
        data: new FormData($("#Form1")[0]),
        success: function (response) {
            let result = $.parseJSON(response);
            console.log(result);
            if (result.code == 200) {
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error: function (response) {
            $("#fix_load").html("添加失败");
            $("#fix_load").hide();
        }
    });
})
$("#delHomeRouling").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/RemoveHomeRouling",
        data: $("#delHomeRoulingForm").serialize(),
        dataType: "json",
        success: function (response) {
            if(response.data){
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            }else{
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
        },
        error:function (res) {
            $("#fix_load").html("修改失败");
            $("#fix_load").hide();
        }
    });
})
$("#updateRoulingMessage").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/UpdateHomeRouling",
        data: $("#updateRoulingMessageForm").serialize(),
        dataType: "json",
        success: function (response) {
            if(response.code == 200){
                $("#fix_load").html("修改成功");
                $("#fix_load").hide();
            }else{
                $("#fix_load").html("修改失败");
                $("#fix_load").hide();
            }
            
        },
        error:function (response) {
           $("#fix_load").html("修改失败");
           $("#fix_load").hide();
        }
    });
})
$("#addRoulingMessage").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/SaveRoulingMessage",
        data: $("#addRoulingMessageForm").serialize(),
        dataType: "json",
        success: function (response) {
            if(response.code == 200){
                $("#fix_load").html("添加成功");
                $("#fix_load").hide();
            }else{
                $("#fix_load").html("添加失败");
                $("#fix_load").hide();
            }
            
        },
        error:function (response) {
           $("#fix_load").html("添加失败");
           $("#fix_load").hide();
        }
    });
})
$("#delRoulingMessage").click((e)=>{
   e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/RemoveRoulingMessage",
        data: $("#delRoulingMessageForm").serialize(),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("删除成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("删除失败");
                $("#fix_load").hide();
            }
        },
        error: function (data) {
            $("#fix_load").html("删除失败");
            $("#fix_load").hide();
        },
    });
})

$("#saveHomeMessage").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/SaveHomeArticle",
        processData: false,
        contentType: false,
        data: new FormData($("#saveHomeMessageForm")[0]),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("保存成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("保存失败");
                $("#fix_load").hide();
            }
        },
        error: function (data) {
            $("#fix_load").html("保存失败");
            $("#fix_load").hide();
        },
    });
})
$("#removeHomeArticle").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/RemoveHomeArticle",
        data: $("#removeHomeArticleForm").serialize(),
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                $("#fix_load").html("删除成功");
                $("#fix_load").hide();
            } else {
                $("#fix_load").html("删除失败");
                $("#fix_load").hide();
            }
        },
        error: function (data) {
            $("#fix_load").html("删除失败");
            $("#fix_load").hide();
        },
    });
})
$("#updateHomeArticle").click((e)=>{
    e.preventDefault();
    $("#fix_load").show();
    $.ajax({
        type: "POST",
        url: "/covid19-show/UpdateHomeArticle",
        processData: false,
        contentType: false,
        data: new FormData($("#updateHomeArticleForm")[0]),
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
        error: function (res) {
            $("#fix_load").html("删除失败");
            $("#fix_load").hide();
        }
    });
})