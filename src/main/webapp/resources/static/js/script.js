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
    slidesToShow:1,
    slidesToScroll:1,
    autoplay:true,
    speed:1000,
    autoplaySpeed:2500,
    variableWidth: true,
    adaptiveHeight:true
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
    adaptiveWidth:true,
    adaptiveHeight:true,
    variableWidth: true,
    variableHeight: true,
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


    jQuery(".fa-sliders").on("click",function (e) {
        e.preventDefault();
        jQuery(".close_filters-btn").toggleClass("close_filters-btn_active");
        jQuery(".categories__full").toggleClass("categories_anime");
        jQuery(".sales").toggleClass("main-blur")
        jQuery("body").toggleClass("no_scroll")
    });

    jQuery(".close_filters").on("click", function (e){
        e.preventDefault();
        jQuery(".close_filters-btn").toggleClass("close_filters-btn_active");
        jQuery(".categories__full").toggleClass("categories_anime");
        jQuery(".sales").toggleClass("main-blur")
        jQuery("body").toggleClass("no_scroll")
    });

    jQuery( function() {
        jQuery( "#slider-range" ).slider({
            range: true,
            min: 50,
            max: 10000,
            values: [ 750, 9000 ],
            slide: function( event, ui ) {
                jQuery( ".amount" ).val( ui.values[ 0 ]);
                jQuery( ".amount2" ).val( ui.values[ 1 ] );
            }
        });
        jQuery( ".amount" ).val(jQuery( "#slider-range" ).slider( "values", 0 ) );
        jQuery( ".amount2" ).val(jQuery( "#slider-range" ).slider( "values", 1 ) );
    });


});

// function viewVisible(){
//     document.getElementsByClassName("categories").style.visibility="visible";
//     document.getElementsByClassName("categories").style.right=0;
//
// }


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

