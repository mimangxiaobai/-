$(function () {
    
    var d1 = $.Deferred();
    var d2 = $.Deferred();
    var d3 = $.Deferred();
    var d4 = $.Deferred();
    var d5 = $.Deferred();
    var d6 = $.Deferred();
    function send1() {
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListHomeRouling",
            dataType: "json",
            success: function (response) {
              console.log(response.code)
              if (response.code != 200) {
                alert(response.message)
              } else {
                let content = ``;
                for (let index = 0; index < response.data.length; index++) {
                  if (index == 0) {
                    content +=
                      `<div class="swiper-slide swiper-slide-active"><img src="${response.data[index].imgUrl}" style="width: 100%;" alt=""></div>`
                  } else if (index == 1) {
                    content += ` <div class="swiper-slide swiper-slide-next">
        <img src="${response.data[index].imgUrl}" style="width: 100%;" alt="">
        </div>`
                  } else {
                    content += ` <div class="swiper-slide">
        <img src="${response.data[index].imgUrl}" style="width: 100%;" alt="">
        </div>`
                  }
                }
                $("#geng-swiper").html(content);
                console.log("-------")
                d1.resolve( "Fish" )
              }
            },
            error: function (response) {
              console.log("error")
              console.log(response)
            }
        });
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListRoulingMessage",
            dataType: "json",
            success: function (response) {
              let con = "";
              RoulingMEssageLeng = response.data.length;
              console.log(response.data)
              for (let index = 0; index < response.data.length; index++) {
                console.log("-----for-------")
                con += `
                          <div>
                            <div>
                            ${response.data[index].title}
                            </div>
                            <div>
                            ${response.data[index].content}
                            </div>
                        </div>
                        `;
              }
              console.log("-----insert-------")
              $("#gengRoulingMessage").html(con);
              d2.resolve( "Fish" )
            }
        });
       
        
        
    }
    function send2() {
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListHomeArticle",
            dataType: "json",
            success: function (response) {
              console.log(response.data)
              let con = "<div>国际疫情评论</div>";
              for (let index = 0; index < response.data.length; index++) {
                con += `
                <div style="padding: 10px 0px;  cursor: pointer;">
                  <div>
                    <div class="col-lg-2 col-md-3 col-sm-4 col-xs-4">
                      <img src="${response.data[index].imgUrl}" alt=""
                      style="width: 100%;">
                    </div>
                    <div class="col-lg-10 col-md-9 col-sm-7 col-xs-7">
                          <div>
                              ${response.data[index].title}
                          </div>
                    </div>
                  </div>
                </div>
                `
              }
              $("#gengHomeArticle").html(con);
              d3.resolve( "Fish" )
            }
        });
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListRumor",
            dataType: "json",
            success: function (response) {
              let con = "";
              for (let index = 0; index < response.data.length; index++) {
                con += `<div>
                    <div>${response.data[index].content}</div>
                    <img src="${response.data[index].isRumor == 0?'./images/tag1.png':'./images/tag2.png'}" alt="">
                  </div>`
              }
              $("#gengRumor").html(con);
              d4.resolve( "Fish" )
            }
          });
         
    }
    function send3() {
        $.ajax({
            type: "POST",
            url: "/covid19-show/ListQuestion",
            dataType: "json",
            success: function (response) {
              let con = "";
              for (let index = 0; index < response.data.length; index++) {
                con += `<div class="fangyi_card row">
                  <div class="col-lg-1 col-md-2 col-xs-4 col-sm-2">
                      <img src="${response.data[index].imgUrl}" alt="" style="width: 100%;">
                  </div>
                  <div class=" col-lg-11 col-md-10 col-xs-8 col-sm-10">
                  <div class="col-lg-10 col-md-10 col-sm-9">
                      <div>${response.data[index].title}</div>
                  </div>
                  <div class="col-lg-2 col-md-2 col-sm-3">
                      <a href="">${response.data[index].content}</a>
                  </div>
              </div>
              <div id="articleId">问题id:${response.data[index].id}</div>
                  </div>
                  
                  `
              }
              $("#gengQuestion").html(con);
              d5.resolve( "Fish" )
            }
          });
          $.ajax({
            type: "POST",
            url: "/covid19-show/ListCovidData",
            dataType: "json",
            success: function (response) {
                console.log("+++++++++++++================++++++++++++++")
                console.log(response)
               $("#nowSureMore").html(response.data[0].nowSureMore);
               $("#nowSure").html(response.data[0].nowSure);
               $("#nowAddMore").html(response.data[0].nowAddMore);
               $("#nowAdd").html(response.data[0].nowAdd);
               $("#nowIcuMore").html(response.data[0].nowIcuMore);
               $("#nowIcu").html(response.data[0].nowIcu);
               $("#addSureMore").html(response.data[0].addSureMore);
               $("#addSure").html(response.data[0].addSure);
               $("#addDiedMore").html(response.data[0].addDiedMore);
               $("#addDied").html(response.data[0].addDied);
               $("#addSaveMore").html(response.data[0].addSaveMore);
               $("#addSave").html(response.data[0].addSave)
               d6.resolve( "Fish" )
              }
        
        
          });
    }
    function send4() {
          $.ajax({
            type: "POST",
            url: "/covid19-show/ListForeignCovidData",
            dataType: "json",
            success: function (response) {
                
              $("#worldNowSureMore").html(response.data[0].nowSureMore);
              $("#worldNowSure").html(response.data[0].nowSure);
              $("#worldAddSureMore").html(response.data[0].addSureMore);
              $("#worldAddSure").html(response.data[0].addSure);
              $("#worldAddDiedMore").html(response.data[0].addDiedMore);
              $("#worldAddDied").html(response.data[0].addDied);
              $("#worldAddSaveMore").html(response.data[0].addSaveMore);
              $("#worldAddSave").html(response.data[0].addSave);
              console.log($("#nowSureMore"))
            //   console.log("+++++++++++++++++++")
            //   console.log(response.data[0])
            //   console.log("+++++++++++++++++++")
            }
          });
    }
    send1();
    $.when( d1, d2 ).done(function ( v1, v2) {  
        send2(); 
    });  
    $.when( d3, d4 ).done(function ( v3, v4) {  
        send3(); 
    }); 
    $.when( d5, d6 ).done(function ( v5, v6) {  
        send4(); 
    });  
    
     
})