

$(window).resize(function () {
  window.location.reload();
});
//---------------------------------------
$('#profile').css({
  height: $('#home').height()
})

var load_hight = $(window).height();

$('.load_1>div').css({
  height: load_hight
})
//--------------------------------------


//-------------------
$(".pc_news>div:nth-child(2)>div").mouseover(function () {
  $(".top_3>div>.swiper-container>.swiper-wrapper").css({
    transition: "all 0.8s "
  })
  var index_news = $(this).index();
  var width_news = $(".swiper-container2>.swiper-wrapper>.swiper-slide").width();
  $('.swiper-pagination-current').html(index_news + 1);
  $(".top_3>div>.swiper-container>.swiper-wrapper").css({
    transform: "translate3d(" + -width_news * index_news + "px,0,0)"
  });
});

$(".pc_news>div:nth-child(2)>div").mouseleave(function () {
  $(".top_3>div>.swiper-container>.swiper-wrapper").css({
    transition: "all 0s "
  })
});
//--------------------------------------------


//---------------------------------
$('.swiper-video').click(function (e) {
  e.preventDefault();
  var a = $('video').hasClass("play");
  if (a) {
    $('video').get(0).pause();
    $('video').removeClass("play");
    $(".swiper-video>.fa-3x").fadeIn();
  } else {
    $('video').get(0).play();
    $('video').addClass("play");
    $(".swiper-video>.fa-3x").fadeOut();
  }

});
//----------------------------------


//----------------------------
var scroll_top = $(document).scrollTop();
var img_top_width = $(".top_1").height();
if (scroll_top >= img_top_width + 57.6) {
  $('.tabs').addClass("fix-top");
} else {
  $('.tabs').removeClass("fix-top")
}

$(document).scroll(function () {
  scroll_top = $(document).scrollTop();

  img_top_width = $(".top_1").height();
  if (scroll_top >= img_top_width + 57.6) {
    $('.tabs').addClass("fix-top");

  } else {
    $('.tabs').removeClass("fix-top")
  }
});
//----------------------------------------
$('#yao_btn').click(function () {


  var so_num = $("#yao_so").val();
  $.ajax({
    type: "POST",
    url: "/covid19-show/ListRumorByFuzzy",
    data: {
      con: so_num
    },
    dataType: "json",
    success: function (response) {
      if (response.code == 200 && response.data.length > 0) {
        let con = "";
        for (let index = 0; index < response.data.length; index++) {
          con += `<div>
              <div>${response.data[index].content}</div>
              <img src="${response.data[index].isRumor == 0?'./images/tag1.png':'./images/tag2.png'}" alt="">
            </div>`
        }
        $("#gengRumor").html(con);
      } else {
        $("#gengRumor").html("无数据")
      }
    }
  });


})
//-----------------------------------------------------------------------------------------------
var page_width = $(document).width();
if (page_width >= 768) {
  var left_to_page2 = ($('.pc_heng>div').width() - 318) / 2;
  $('.swiper-button-prev1,.swiper-button-prev2').css({
    left: left_to_page2 + 10
  })
  $('.swiper-button-next1,.swiper-button-next2').css({
    right: left_to_page2 + 10
  })
}
var RoulingMEssageLeng = 0;


//-------------------------------
var tops = -40;

setTimeout(() => {
  setInterval(() => {
    $(".top_4>div").css({
      top: tops
    })
    tops -= 40;
    if (tops < -40 * RoulingMEssageLeng - 1 + 10) {
      tops = 0;
    }
  }, 2000);
}, 800);

//----------------------------------------------------------
//-----------------------------------------------------------------------------------------