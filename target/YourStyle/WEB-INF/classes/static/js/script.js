$(document).ready(function() {
$('.stocks__items').slick({
    arrows:true,
    dots:true,
    slidesToShow:4,
    slidesToScroll:4,
    speed:1200,
    variableWidth: true,
    swipe:false,
    // adaptiveHeight:true,
});
$('.children__slider').slick({
    arrows:false,
    dots:false,
    adaptiveHeight:false,
    slidesToShow:1,
    slidesToScroll:1,
    autoplay:true,
    speed:1000,
    autoplaySpeed:2500,
    variableWidth: true,
    adaptiveHeight:true,
});

$('.filter__title').click(function(event){

    $(this).toggleClass('active').next().slideToggle(300);
    
});


$('.links__title').click(function(event){

  $(this).toggleClass('active').next().slideToggle(300);
  
});


$('.buypage__slider').slick({
    arrows:true,
    dots:true,
    adaptiveHeight:true,
    variableWidth: true,
    slidesToShow:1,
    slidesToScroll:1,
    speed:800,
    
});

$('.recomendation__slider').slick({
    arrows:true,
    dots:true,
    adaptiveHeight:true,
    variableWidth: true,
    slidesToShow:5,
    slidesToScroll:1,
    speed:300,
    Infinity:true,
    swipe:false,
    // centerMode: true,
    
});

jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.buypage__counter input');
    jQuery('.buypage__counter').each(function() {
      var spinner = jQuery(this),
        input = spinner.find('input[type="number"]'),
        btnUp = spinner.find('.quantity-up'),
        btnDown = spinner.find('.quantity-down'),
        min = input.attr('min'),
        max = input.attr('max');

      btnUp.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue >= max) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue + 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

      btnDown.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue <= min) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue - 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

    });

    jQuery(".menu-btn").on("click",function (e) {
        e.preventDefault();
        jQuery(this).toggleClass("menu-btn_active");
        jQuery(".menubox").toggleClass("menubox-anime")
        jQuery(".main__container").toggleClass("main-blur")
        jQuery("body").toggleClass("no_scroll")
    });
    jQuery(".filter__block").on("click",function (e) {
        e.preventDefault();
        jQuery(this).toggleClass("menu-btn_active");
    });

    jQuery( function() {
        jQuery( "#slider-range" ).slider({
            range: true,
            min: 50,
            max: 10000,
            values: [ 750, 9000 ],
            slide: function( event, ui ) {
                jQuery( "#amount" ).val( ui.values[ 0 ]);
                jQuery( "#amount2" ).val( ui.values[ 1 ] );
            }
        });
        jQuery( "#amount" ).val(jQuery( "#slider-range" ).slider( "values", 0 ) );
        jQuery( "#amount2" ).val(jQuery( "#slider-range" ).slider( "values", 1 ) );
    });

    jQuery(".man_link").on("click",function (e) {
        e.preventDefault();


        // jQuery(this).toggleClass("man_active_link");
        // jQuery(".woman_link").toggleClass("woman_off_link")
        // jQuery(".kids_link").toggleClass("kids_off_link")
        //
        // jQuery(".man_block").toggleClass("man_active_block");
        // jQuery(".woman_block").toggleClass("woman_off_block")
        // jQuery(".kids_block").toggleClass("kids_off_block")

        // jQuery(this).removeClass("man_link").addClass("man_active_link");
        // jQuery(".woman_link").removeClass("woman_link").addClass("woman_off_link");
        // jQuery(".kids_link").removeClass("kids_link").addClass("kids_off_link");
        //
        // jQuery(".man_block").removeClass("man_block").addClass("man_active_block");
        // jQuery(".woman_block").removeClass("woman_block").addClass("woman_off_block");
        // jQuery(".kids_block").removeClass("kids_block").addClass("kids_off_block");

        // jQuery(".man_block").fadeToggle(100);

    });
    
    jQuery(".woman_link").on("click",function (e) {
        e.preventDefault();
        // jQuery(this).toggleClass("woman_active_link");
        // jQuery(".man_link").toggleClass("man_off_link")
        // jQuery(".kids_link").toggleClass("kids_off_link")
        //
        // jQuery(".woman_block").toggleClass("woman_active_block");
        // jQuery(".man_block").toggleClass("man_off_block")
        // jQuery(".kids_block").toggleClass("kids_off_block")

        // jQuery(this).removeClass("woman_link").addClass("woman_active_link");
        // jQuery(".man_link").removeClass("man_link").addClass("man_off_link")
        // jQuery(".kids_link").removeClass("kids_link").addClass("kids_off_link")
        //
        // jQuery(".woman_block").removeClass("woman_block").addClass("woman_active_block");
        // jQuery(".man_block").removeClass("man_block").addClass("man_off_block")
        // jQuery(".kids_block").removeClass("kids_block").addClass("kids_off_block")
        // jQuery(".woman_block").fadeToggle(100);

    });

    jQuery(".kids_link").on("click",function (e) {
        e.preventDefault();
        // jQuery(this).toggleClass("kids_active_link");
        // jQuery(".woman_link").toggleClass("woman_off_link")
        // jQuery(".man_link").toggleClass("man_off_link")
        //
        // jQuery(".kids_block").toggleClass("kids_active_block");
        // jQuery(".woman_block").toggleClass("woman_off_block")
        // jQuery(".man_block").toggleClass("man_off_block")

        // jQuery(this).removeClass("kids_link").addClass("kids_active_link");
        // jQuery(".woman_link").removeClass("woman_link").addClass("woman_off_link")
        // jQuery(".man_link").removeClass("man_link").addClass("man_off_link")
        //
        // jQuery(".kids_block").removeClass("kids_block").addClass("kids_active_block");
        // jQuery(".woman_block").removeClass("woman_block").addClass("woman_off_block")
        // jQuery(".man_block").removeClass("man_block").addClass("man_off_block")

        // jQuery(".kids_block").fadeToggle(100);
    });

});



// function viewMan(){
//                      document.getElementsByClassName("kids_block").style.display="none";
//                     document.getElementsByClassName("man_block").style.display="block";
//                     document.getElementsByClassName("woman_block").style.display="none";
//
//                  };
// function viewWoman(){
//     document.getElementsByClassName("kids_block").style.display="none";
//     document.getElementsByClassName("man_block").style.display="none";
//     document.getElementsByClassName("woman_block").style.display="block";
//
// };
// function viewKids(){
//     document.getElementsByClassName("kids_block").style.display="block";
//     document.getElementsByClassName("man_block").style.display="none";
//     document.getElementsByClassName("woman_block").style.display="none";
//
// };

$(document).ready(function () {

    $(".woman_block").hide();
    $(".kids_block").hide();
    $(".man_link").click(function () {
        $(".woman_block").hide();
        $(".kids_block").hide();
        $(".man_block").show()
    });

    $(".woman_link").click(function () {
        $(".man_block").hide();
        $(".kids_block").hide();
        $(".woman_block").show()
    });

    $(".kids_link").click(function () {
        $(".woman_block").hide();
        $(".man_block").hide();
        $(".kids_block").show()
    });

});
document.getElementById('btcProduct').onclick = function(){
    calcCost();
};

function calcCost(){
    var selectProd = document.getElementById('selectProduct').value;

    var quantityProd = document.getElementById('quantityProduct').value;

    var total = quantityProd * selectProd;
    document.getElementById('priceProduct').innerHTML = total + ' UAH';
    document.getElementById('infoProduct').style.display = 'flex';

}

