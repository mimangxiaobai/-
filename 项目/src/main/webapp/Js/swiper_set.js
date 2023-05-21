window.onload = function () {

    $("#profile").addClass("block");
     //--------------------------------------------
     var tabsSwiper7 = new Swiper('#tabs-container7', {
        navigation: {
            nextEl: '.swiper-button-next3',
            prevEl: '.swiper-button-prev3',
          },
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_7 .active").removeClass('active');
                $(".tabs_7 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_7 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_7 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper7.slideTo($(this).index())
    })
    /////////////////////////--------------------
   
    var swiper8 = new Swiper('.swiper-container8', {
      speed: 600,
      parallax: true,
    //   pagination: {
    //     el: '.swiper-pagination',
    //     clickable: true,
    //   },
      navigation: {
        nextEl: '.swiper-button-next3',
        prevEl: '.swiper-button-prev3',
      },
    });
    //------------------------------------------------------
    
    var swiper7 = new Swiper('.swiper-container7', {
      effect: 'coverflow',
      grabCursor: true,
      centeredSlides: true,
      slidesPerView: 'auto',
      coverflowEffect: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows : true,
      },
      pagination: {
        el: '.Pagination2',
      },
    });
  
      //--------------------------------------------
      var tabsSwiper6 = new Swiper('#tabs-container6', {
        navigation: {
            nextEl: '.swiper-button-next3',
            prevEl: '.swiper-button-prev3',
          },
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_6 .active").removeClass('active');
                $(".tabs_6 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_6 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_6 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper6.slideTo($(this).index())
    })
    //--------------------------------------------
    var tabsSwiper5 = new Swiper('#tabs-container5', {
        navigation: {
            nextEl: '.swiper-button-next2',
            prevEl: '.swiper-button-prev2',
          },
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_5 .active").removeClass('active');
                $(".tabs_5 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_5 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_5 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper5.slideTo($(this).index())
    })
    //--------------------------------------------
    var tabsSwiper4 = new Swiper('#tabs-container4', {
        navigation: {
            nextEl: '.swiper-button-next1',
            prevEl: '.swiper-button-prev1',
          },
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_4 .active").removeClass('active');
                $(".tabs_4 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_4 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_4 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper4.slideTo($(this).index())
    })
    //-------------------------------------------------
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
    //---------------------------------------------
    var tabsSwiper3 = new Swiper('#tabs-container3', {
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_3 .active").removeClass('active');
                $(".tabs_3 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_3 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_3 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper3.slideTo($(this).index())
    })
    //-----------------------------------------------
    var tabsSwiper2 = new Swiper('#tabs-container2', {
        speed: 500,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_2 .active").removeClass('active');
                $(".tabs_2 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_2 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_2 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper2.slideTo($(this).index())
    })
    //-------------------------------------------------------
    var tabsSwiper1 = new Swiper('#tabs-container1', {
        speed: 500,
        slidesPerView:'auto',
        autoHeight:true,
        on: {
            slideChangeTransitionStart: function () {
                $(".tabs_1 .active").removeClass('active');
                $(".tabs_1 a").eq(this.activeIndex).addClass('active');
            }
        }
    })
    $(".tabs_1 a").on('click', function (e) {
        e.preventDefault()
        $(".tabs_1 .active").removeClass('active')
        $(this).addClass('active')
        tabsSwiper1.slideTo($(this).index())
    })
    
    //------------------------------------------------
    $("#profile").removeClass("block");
    //-------------------------------------------------------
    setTimeout(() => {
        $('.load_1').hide();
    }, 500);
   
}
